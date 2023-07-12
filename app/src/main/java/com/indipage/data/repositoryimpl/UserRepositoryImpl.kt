package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.UserDataSource
import com.indipage.data.dto.response.UserResponseDto
import com.indipage.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource
) : UserRepository {

    override suspend fun getUserInfo(): Result<UserResponseDto> {
        return kotlin.runCatching {
            dataSource.getUserInfo().data
        }
    }
}