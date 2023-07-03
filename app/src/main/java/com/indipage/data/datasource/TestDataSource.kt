package com.indipage.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.indipage.data.api.TestApi
import com.indipage.data.dto.kakao.KaKaoImage

class TestDataSource(
    private val apiService: TestApi,
    private val query: String
) : PagingSource<Int, KaKaoImage>() {
    override fun getRefreshKey(state: PagingState<Int, KaKaoImage>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, KaKaoImage> {
        val position = params.key ?: 1
        return runCatching {
            val kakaoResult =
                apiService.getTestApi(query, sort = "accuracy", position, size = 10)
                    .body()?.documents
            PagingSource.LoadResult.Page(
                data = kakaoResult!!,
                prevKey = if (position == 0) null else position - 1,
                nextKey = if (kakaoResult.isEmpty()) null else position + 1
            )
        }.getOrElse {
            PagingSource.LoadResult.Error(it)
        }
    }
}