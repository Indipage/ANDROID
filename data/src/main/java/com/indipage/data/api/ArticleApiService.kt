package com.indipage.data.api

import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.data.dto.response.ResponseArticleSlideDto
import com.indipage.data.dto.response.ResponseArticleWeeklyDto
import retrofit2.http.GET
import retrofit2.http.PATCH

interface ArticleApiService {

    companion object {
        const val ARTICLE = "article"
        const val WEEKLY = "weekly"
        const val USER = "user"
        const val SLIDE = "slide"
    }

    @GET("/$ARTICLE/$WEEKLY")
    suspend fun getArticleWeekly(): BaseResponseNullable<ResponseArticleWeeklyDto>

    @GET("/$USER/$WEEKLY/$SLIDE")
    suspend fun getArticleSlide(): BaseResponseNullable<ResponseArticleSlideDto>

    @PATCH("/$USER/$WEEKLY/$SLIDE")
    suspend fun putArticleSlide(): NullResponse

    @GET("/$ARTICLE")
    suspend fun getArticleAll(): BaseResponseNullable<List<ResponseArticleAllDto>>
}