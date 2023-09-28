package com.indipage.data.api

import com.google.gson.annotations.SerializedName
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.data.dto.response.ResponseTokenDto
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {
    @POST("/auth/login")
    suspend fun postSignIn(
        @Body request: RequestSignInDto
    ): BaseResponseNullable<ResponseTokenDto>
}