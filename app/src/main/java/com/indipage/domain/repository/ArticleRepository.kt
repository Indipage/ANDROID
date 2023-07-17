package com.indipage.domain.repository

import com.indipage.data.dto.response.ResponseArticleWeeklyDto

interface ArticleRepository {
    suspend fun getArticleWeekly(): Result<ResponseArticleWeeklyDto>
}