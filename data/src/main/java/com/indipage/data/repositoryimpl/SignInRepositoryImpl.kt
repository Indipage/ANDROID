package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.SignInDataSource
import com.indipage.data.dto.response.toTokenEntity
import com.indipage.domain.model.Token
import com.indipage.domain.repository.SignInRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val signInDataSource: SignInDataSource
) : SignInRepository {
    override suspend fun postGoogleLogin(code: String): Flow<Token> {
        return flow {
            val result = kotlin.runCatching {
                signInDataSource.postGoogleLogin(code).data?.toTokenEntity()
            }
            val valueToEmit = result.getOrDefault(Token(""))
            valueToEmit?.let { emit(it) }
        }
    }
}