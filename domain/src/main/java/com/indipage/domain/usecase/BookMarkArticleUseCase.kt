package com.indipage.domain.usecase

import com.indipage.domain.model.Article
import com.indipage.domain.repository.BookMarkRepository
import kotlinx.coroutines.flow.Flow

class BookMarkArticleUseCase(
    private val repository: BookMarkRepository
) {
    suspend operator fun invoke(): Flow<List<Article>?> =
        repository.getSavedArticles()
}