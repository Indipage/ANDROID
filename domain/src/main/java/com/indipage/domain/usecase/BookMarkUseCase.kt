package com.indipage.domain.usecase

import com.indipage.domain.model.Article
import com.indipage.domain.model.Space

import com.indipage.domain.repository.BookMarkRepository

class BookMarkUseCase(
    private val repository: BookMarkRepository
) {
    suspend fun getSavedArticles(): Result<List<Article>?> =
        repository.getSavedArticles()

    suspend fun getSavedSpaces(): Result<List<Space>?> =
        repository.getSavedSpaces()
}