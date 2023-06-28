package com.indipage.data.repositoryimpl

import com.indipage.data.api.TestApi
import com.indipage.data.datasource.TestDataSource
import com.indipage.data.dto.ExampleResponse
import com.indipage.domain.repository.TestApiRepository
import retrofit2.Response

class TestRepositoryImpl (
    private val testDataSource: TestDataSource
) {
    suspend fun getTestApi():Response<ExampleResponse> =
        testDataSource.getTestApi()
}