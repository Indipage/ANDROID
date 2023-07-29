package com.indipage.domain.repository

import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.domain.entity.ArticleAll
import com.indipage.domain.entity.ArticleSlide
import com.indipage.domain.entity.ArticleWeekly

interface ArticleRepository {
    suspend fun getArticleWeekly(): Result<ArticleWeekly?>

    suspend fun getArticleSlide(): Result<ArticleSlide?>

    suspend fun putArticleSlide(): Result<Int>

    suspend fun getArticleAll(): Result<List<ArticleAll>?>
}