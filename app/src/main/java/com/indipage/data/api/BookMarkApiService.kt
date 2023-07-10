package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.ResponseTestRecyclerview
import com.indipage.data.dto.response.SavedArticle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookMarkApiService {
    @GET("/user/bookmark/article")
    suspend fun getSavedArticles(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): BaseResponse<List<SavedArticle>>
}