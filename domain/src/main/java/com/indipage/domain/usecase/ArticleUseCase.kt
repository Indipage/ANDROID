package com.indipage.domain.usecase

import com.indipage.domain.model.ArticleAll
import com.indipage.domain.model.ArticleSlide
import com.indipage.domain.model.ArticleWeekly
import com.indipage.domain.repository.ArticleRepository

class ArticleUseCase(
    private val repository: ArticleRepository
) {
    suspend fun getArticleWeekly(): Result<ArticleWeekly?> = repository.getArticleWeekly()

    suspend fun getArticleSlide(): Result<ArticleSlide?> = repository.getArticleSlide()

    suspend fun putArticleSlide(): Result<Int> = repository.putArticleSlide()

    suspend fun getArticleAll(): Result<List<ArticleAll>?> = repository.getArticleAll()
}