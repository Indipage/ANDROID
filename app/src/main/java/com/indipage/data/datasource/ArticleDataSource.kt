package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.ResponseArticleWeeklyDto

interface ArticleDataSource {
    suspend fun getArticleWeekly(): BaseResponse<ResponseArticleWeeklyDto>
}