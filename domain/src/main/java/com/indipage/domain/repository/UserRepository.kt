package com.indipage.domain.repository

import com.indipage.domain.model.UserInfo


interface UserRepository {
    suspend fun getUserInfo(): Result<UserInfo>

}