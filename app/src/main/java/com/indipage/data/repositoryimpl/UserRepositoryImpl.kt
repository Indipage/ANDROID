package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.UserDataSource
import com.indipage.data.dto.response.toUserInfoEntity
import com.indipage.domain.entity.UserInfo
import com.indipage.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource
) : UserRepository {

    override suspend fun getUserInfo(): Result<UserInfo> {
        return kotlin.runCatching {
            dataSource.getUserInfo().data.toUserInfoEntity()
        }
    }
}