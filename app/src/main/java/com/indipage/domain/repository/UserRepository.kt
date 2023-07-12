package com.indipage.domain.repository

import com.indipage.domain.entity.UserInfo

interface UserRepository {
    suspend fun getUserInfo(): Result<UserInfo>

}