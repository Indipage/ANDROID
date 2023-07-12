package com.indipage.domain.repository

import com.indipage.data.dto.response.UserResponseDto

interface UserRepository {
    suspend fun getUserInfo(): Result<UserResponseDto>

}