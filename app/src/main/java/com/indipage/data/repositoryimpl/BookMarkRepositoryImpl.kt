package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.BookMarkDataSource
import com.indipage.data.dto.response.SavedArticle
import com.indipage.data.dto.response.SavedSpace
import com.indipage.domain.repository.BookMarkRepository
import javax.inject.Inject

class BookMarkRepositoryImpl @Inject constructor(
    private val dataSource: BookMarkDataSource
) : BookMarkRepository {
    override suspend fun getSavedArticles(): Result<List<SavedArticle>> {
        return runCatching {
            dataSource.getSavedArticles().data
        }
    }

    override suspend fun getSavedSpaces(): Result<List<SavedSpace>> {
        return runCatching {
            dataSource.getSavedSpaces().data
        }
    }
}