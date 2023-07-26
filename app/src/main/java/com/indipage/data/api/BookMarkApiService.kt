package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.response.ResponseArticleDto
import com.indipage.data.dto.response.ResponseSpaceDto
import retrofit2.http.GET

interface BookMarkApiService {
    @GET("/bookmark/article")
    suspend fun getSavedArticles(): BaseResponse<List<ResponseArticleDto>>

    @GET("/bookmark/space")
    suspend fun getSavedSpaces(): BaseResponseNullable<List<ResponseSpaceDto>>
}