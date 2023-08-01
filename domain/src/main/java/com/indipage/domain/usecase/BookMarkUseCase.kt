package com.indipage.domain.usecase

import com.indipage.domain.model.Article
import com.indipage.domain.model.ArticleDetail
import com.indipage.domain.model.Space
import com.indipage.domain.repository.ArticleDetailRepository

import com.indipage.domain.repository.BookMarkRepository
import kotlinx.coroutines.flow.Flow

class BookMarkUseCase(
    private val repository: BookMarkRepository
) {
    suspend fun getSavedArticles(): Flow<List<Article>?> =
        repository.getSavedArticles()

    suspend fun getSavedSpaces(): Result<List<Space>?> =
        repository.getSavedSpaces()
}

