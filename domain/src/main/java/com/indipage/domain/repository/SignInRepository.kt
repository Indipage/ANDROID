package com.indipage.domain.repository

import com.indipage.domain.model.Token
import kotlinx.coroutines.flow.Flow

interface SignInRepository {
    suspend fun postGoogleLogin(code: String): Flow<Token>
}