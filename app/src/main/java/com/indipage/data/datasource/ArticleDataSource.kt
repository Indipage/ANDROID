package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.ResponseArticleSlideDto
import com.indipage.data.dto.response.ResponseArticleWeeklyDto

interface ArticleDataSource {
    suspend fun getArticleWeekly(): BaseResponse<ResponseArticleWeeklyDto>

    suspend fun getArticleSlide(): BaseResponse<ResponseArticleSlideDto>
}