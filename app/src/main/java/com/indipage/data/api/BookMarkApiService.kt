package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.ResponseArticleDto
import com.indipage.data.dto.response.SavedArticle
import com.indipage.data.dto.response.SavedSpace
import retrofit2.http.GET

interface BookMarkApiService {
    @GET("/bookmark/article")
    suspend fun getSavedArticles(): BaseResponse<List<ResponseArticleDto>>

    @GET("/user/bookmark/article")
    suspend fun getSavedSpaces(): BaseResponse<List<SavedSpace>>
}