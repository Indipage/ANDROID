package com.indipage.data.datasource.remote

import com.indipage.data.api.SignInApiService
import com.indipage.data.datasource.SignInDataSource
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.data.dto.response.ResponseTokenDto
import javax.inject.Inject

class SignInDataSourceImpl @Inject constructor(
    private val apiService: SignInApiService
) : SignInDataSource {
    override suspend fun postGoogleLogin(accessToken: String): BaseResponseNullable<ResponseTokenDto> {
        return apiService.postSignIn(RequestSignInDto(accessToken, "GOOGLE"))
    }
}