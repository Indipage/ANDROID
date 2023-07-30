package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.UserResponseDto

interface UserDataSource {
    suspend fun getUserInfo(): BaseResponse<UserResponseDto>

}