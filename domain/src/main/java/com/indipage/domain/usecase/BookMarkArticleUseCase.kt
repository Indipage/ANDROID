package com.indipage.domain.usecase

import com.indipage.domain.repository.BookMarkRepository

class BookMarkArticleUseCase(
    private val repository: BookMarkRepository
) {
    suspend operator fun invoke() =
        repository.getSavedArticles()
}