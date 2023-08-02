package com.indipage.domain.usecase


import com.indipage.domain.model.UserInfo
import com.indipage.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserUseCase(
    private val repository: UserRepository
) {
    suspend fun getUserInfo(): Flow<UserInfo> =
        repository.getUserInfo()
}