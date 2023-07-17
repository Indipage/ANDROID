package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.ResponseArticleWeeklyDto
import retrofit2.http.GET

interface ArticleApiService {
    @GET("/article/weekly")
    suspend fun getArticleWeekly(): BaseResponse<ResponseArticleWeeklyDto>
}