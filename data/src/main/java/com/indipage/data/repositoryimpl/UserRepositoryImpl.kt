package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.UserDataSource
import com.indipage.data.dto.response.toUserInfoEntity
import com.indipage.domain.model.UserInfo
import com.indipage.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Optional.empty
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource
) : UserRepository {

    override suspend fun getUserInfo(): Flow<UserInfo> {
        return flow {
            val result = runCatching {
                dataSource.getUserInfo().data.toUserInfoEntity()
            }
            emit(result.getOrDefault(UserInfo(0,"","")))
        }
    }
}