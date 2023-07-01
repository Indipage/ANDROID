package com.indipage.data.api

import org.android.go.sopt.data.model.kakao.ResponsKaKao
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TestApi {
    @GET("/v2/search/image")
    suspend fun getTestApi(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<ResponsKaKao>

}