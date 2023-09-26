package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.response.ResponseTokenDto

interface SignInDataSource {
    suspend fun postGoogleLogin(accessToken: String): BaseResponseNullable<ResponseTokenDto>
}