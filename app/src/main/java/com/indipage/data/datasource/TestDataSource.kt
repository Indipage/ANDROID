package com.indipage.data.datasource

import com.indipage.data.api.TestApi
import com.indipage.data.dto.ExampleResponse
import com.indipage.domain.repository.TestApiRepository
import retrofit2.Response

class TestDataSource(
    private val apiService:TestApi
):TestApiRepository {
    override suspend fun getTestApi(): Response<ExampleResponse> =
        apiService.getExample()
}