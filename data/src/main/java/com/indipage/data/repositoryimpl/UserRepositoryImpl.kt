package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.UserDataSource
import com.indipage.data.dto.response.toUserInfoEntity
import com.indipage.domain.Outcome
import com.indipage.domain.model.UserInfo
import com.indipage.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource
) : UserRepository {

    override suspend fun getUserInfo(): Flow<Outcome<UserInfo>> {
        return flow {
            val result = runCatching {
                dataSource.getUserInfo().data.toUserInfoEntity()
            }
            if (result.isSuccess)
                emit(Outcome.Success(result.getOrDefault(UserInfo(0, "", ""))))
            else
                emit(Outcome.Failure(error = UserInfo(0, "", "")))
        }
    }
}