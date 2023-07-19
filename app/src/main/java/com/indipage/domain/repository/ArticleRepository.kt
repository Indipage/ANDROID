package com.indipage.domain.repository

import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.data.dto.response.ResponseArticleSlideDto
import com.indipage.data.dto.response.ResponseArticleWeeklyDto

interface ArticleRepository {
    suspend fun getArticleWeekly(): Result<ResponseArticleWeeklyDto>

    suspend fun getArticleSlide(): Result<ResponseArticleSlideDto>

    suspend fun putArticleSlide(): Result<Int>

    suspend fun getArticleAll(): Result<List<ResponseArticleAllDto>>
}