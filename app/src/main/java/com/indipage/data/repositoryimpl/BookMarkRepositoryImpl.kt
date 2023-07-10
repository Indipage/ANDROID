package com.indipage.data.repositoryimpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.indipage.data.api.BookMarkApiService
import com.indipage.data.datasource.SavedArticleDataSource
import com.indipage.data.dto.response.SavedArticle
import com.indipage.domain.repository.BookMarkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookMarkRepositoryImpl @Inject constructor(
    private val apiService: BookMarkApiService
) : BookMarkRepository {
    override fun getSavedArticles(): Flow<PagingData<SavedArticle>> =
        Pager(PagingConfig(10)) {
            SavedArticleDataSource(apiService)
        }.flow

}