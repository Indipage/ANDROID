package com.indipage.data.datasource.Remote

import com.indipage.data.api.TestApiService
import com.indipage.data.datasource.TestDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.data.dto.response.ResponseSignInDto
import javax.inject.Inject

class TestDataSourceImpl @Inject constructor(
    private val apiService: TestApiService
) : TestDataSource {
    override suspend fun singIn(requestSignInDto: RequestSignInDto): BaseResponse<ResponseSignInDto> {
        return apiService.singIn(requestSignInDto)
    }
}