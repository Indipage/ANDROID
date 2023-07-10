package com.indipage.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.indipage.data.api.BookMarkApiService
import com.indipage.data.dto.response.SavedArticle

class SavedArticleDataSource(
    private val apiService: BookMarkApiService,
) : PagingSource<Int, SavedArticle>() {
    override fun getRefreshKey(state: PagingState<Int, SavedArticle>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SavedArticle> {
        val position = params.key ?: 1
        return runCatching {
            val result =
                apiService.getSavedArticles(position, 10).data
            LoadResult.Page(
                data = result,
                prevKey = if (position == 0) null else position - 1,
                nextKey = if (result.isEmpty()) null else position + 1
            )
        }.getOrElse {
            LoadResult.Error(it)
        }
    }
}