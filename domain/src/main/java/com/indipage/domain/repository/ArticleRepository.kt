package com.indipage.domain.repository

import com.indipage.domain.model.ArticleAll
import com.indipage.domain.model.ArticleSlide
import com.indipage.domain.model.ArticleWeekly

interface ArticleRepository {
    suspend fun getArticleWeekly(): Result<ArticleWeekly?>

    suspend fun getArticleSlide(): Result<ArticleSlide?>

    suspend fun putArticleSlide(): Result<Int>

    suspend fun getArticleAll(): Result<List<ArticleAll>?>
}