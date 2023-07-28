package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.data.dto.response.ResponseArticleSlideDto
import com.indipage.data.dto.response.ResponseArticleWeeklyDto
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.PUT

interface ArticleApiService {
    @GET("/article/weekly")
    suspend fun getArticleWeekly(): BaseResponseNullable<ResponseArticleWeeklyDto>

    @GET("/user/weekly/slide")
    suspend fun getArticleSlide(): BaseResponseNullable<ResponseArticleSlideDto>

    @PATCH("/user/weekly/slide")
    suspend fun putArticleSlide(): NullResponse

    @GET("/article")
    suspend fun getArticleAll(): BaseResponseNullable<List<ResponseArticleAllDto>>
}