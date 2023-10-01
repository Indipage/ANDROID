package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.UserDataSource
import com.indipage.data.dto.response.toUserInfoEntity
import com.indipage.domain.Outcome
import com.indipage.domain.model.UserInfo
import com.indipage.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber
import java.lang.RuntimeException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource
) : UserRepository {

    override suspend fun getUserInfo(): Flow<Outcome<UserInfo>> = flow {
        val result = runCatching {
            val userInfoEntity = dataSource.getUserInfo()
            Outcome.Success(userInfoEntity.data.toUserInfoEntity())
        }

        val outcome = result.getOrElse {
            val errorCode = (it as? HttpException)?.code() ?: -1
            Outcome.Failure(error = IndipageHttpException(errorCode, "$errorCode"))
        }
        emit(outcome)
    }
}

class IndipageHttpException(
    val httpCode: Int,
    override val message: String,
) : RuntimeException()