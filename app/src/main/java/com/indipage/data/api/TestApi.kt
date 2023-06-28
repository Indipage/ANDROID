package com.indipage.data.api

import com.indipage.data.dto.ExampleResponse
import retrofit2.Response
import retrofit2.http.GET

interface TestApi {

    @GET("sopt/indipage")
    suspend fun getExample(): Response<ExampleResponse>

}