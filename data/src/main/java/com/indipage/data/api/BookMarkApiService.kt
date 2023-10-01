package com.indipage.data.api

import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.response.ResponseArticleDto
import com.indipage.data.dto.response.ResponseSpaceDto
import retrofit2.http.GET

interface BookMarkApiService {

    companion object {
        const val ARTICLE = "article"
        const val SPACE = "space"
        const val BOOKMARK = "bookmark"
    }

    @GET("/$BOOKMARK/$ARTICLE")
    suspend fun getSavedArticles(): BaseResponseNullable<List<ResponseArticleDto>>

    @GET("/$BOOKMARK/$SPACE")
    suspend fun getSavedSpaces(): BaseResponseNullable<List<ResponseSpaceDto>>
}