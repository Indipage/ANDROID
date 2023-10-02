package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.UserResponseDto
import retrofit2.http.GET

interface UserApiService {

    companion object{
        const val USER = "user"
    }

    @GET("/$USER")
    suspend fun getUserInfo(
    ): BaseResponse<UserResponseDto>

}