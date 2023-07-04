package com.indipage.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.indipage.data.api.TestApiService
import com.indipage.data.dto.response.TestRecyclerviewImage

class TestPagingSource(
    private val apiService: TestApiService,
) : PagingSource<Int, TestRecyclerviewImage>() {
    override fun getRefreshKey(state: PagingState<Int, TestRecyclerviewImage>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TestRecyclerviewImage> {
        val position = params.key ?: 1
        return runCatching {
            val Result =
                apiService.getTestApi(position, size = 10)
                    .body()?.testData
            LoadResult.Page(
                data = Result!!,
                prevKey = if (position == 0) null else position - 1,
                nextKey = if (Result.isEmpty()) null else position + 1
            )
        }.getOrElse {
            LoadResult.Error(it)
        }
    }
}