package com.indipage.domain.usecase


import com.indipage.domain.model.UserInfo
import com.indipage.domain.repository.UserRepository

class UserUseCase(
    private val repository: UserRepository
) {
    suspend fun getUserInfo(): Result<UserInfo> =
        repository.getUserInfo()
}