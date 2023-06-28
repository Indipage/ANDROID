package com.indipage.domain.repository

import com.indipage.data.dto.ExampleResponse
import retrofit2.Response

interface TestApiRepository {
    suspend fun getTestApi(): Response<ExampleResponse>
}