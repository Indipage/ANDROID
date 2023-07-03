package com.indipage.data.api

import com.indipage.data.dto.request.RequestTestDto
import com.indipage.data.dto.ResponseTestDto
import com.indipage.data.dto.response.ResponseTestRecyclerview
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TestApi {
    @GET("test-recyclerview")
    suspend fun getTestApi(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<ResponseTestRecyclerview>

    @POST("test")
    suspend fun test(@Body requestSignUpDto: RequestTestDto): Response<ResponseTestDto>

}