package com.indipage.data.api

import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.data.dto.response.ResponseTokenDto
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {
    companion object {
        const val AUTH = "auth"
        const val LOGIN = "login"
    }

    @POST("/$AUTH/$LOGIN")
    suspend fun postSignIn(
        @Body request: RequestSignInDto
    ): BaseResponseNullable<ResponseTokenDto>
}