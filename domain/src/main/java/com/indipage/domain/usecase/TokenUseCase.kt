package com.indipage.domain.usecase

import com.indipage.domain.model.Token
import com.indipage.domain.repository.SignInRepository
import kotlinx.coroutines.flow.Flow

class TokenUseCase(
    private val repository: SignInRepository
) {
    suspend operator fun invoke(code: String): Flow<Token> =
        repository.postGoogleLogin(code)

}