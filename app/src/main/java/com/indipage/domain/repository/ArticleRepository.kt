package com.indipage.domain.repository

import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.data.dto.response.ResponseArticleSlideDto
import com.indipage.data.dto.response.ResponseArticleWeeklyDto
import com.indipage.domain.entity.ArticleWeekly

interface ArticleRepository {
    suspend fun getArticleWeekly(): Result<ArticleWeekly?>

    suspend fun getArticleSlide(): Result<ResponseArticleSlideDto>

    suspend fun putArticleSlide(): Result<Int>

    suspend fun getArticleAll(): Result<List<ResponseArticleAllDto>?>
}