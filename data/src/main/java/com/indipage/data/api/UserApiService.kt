package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.UserResponseDto
import retrofit2.http.GET

interface UserApiService {
    @GET("/user")
    suspend fun getUserInfo(
    ): BaseResponse<UserResponseDto>

}