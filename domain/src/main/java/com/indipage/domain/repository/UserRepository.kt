package com.indipage.domain.repository

import com.indipage.domain.model.UserInfo
import kotlinx.coroutines.flow.Flow


interface UserRepository {
    suspend fun getUserInfo(): Flow<UserInfo>

}