package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.data.dto.response.ResponseSignInDto

interface TestDataSource {
    suspend fun singIn(requestSignInDto: RequestSignInDto): BaseResponse<ResponseSignInDto>

}