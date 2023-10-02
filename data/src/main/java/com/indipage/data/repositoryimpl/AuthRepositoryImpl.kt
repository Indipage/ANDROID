package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.TokenImpl
import com.indipage.domain.SharedPreferenceToken
import com.indipage.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPrefDataSource: TokenImpl,
    private val token: SharedPreferenceToken
) : AuthRepository {
    override fun saveAccessToken(accessToken: String) {
        sharedPrefDataSource.token = accessToken
    }

    override fun getAccessToken(): String {
        return sharedPrefDataSource.token
    }

    override fun getFirst(): Boolean {
        return sharedPrefDataSource.first
    }

    override fun saveFirst(firstCheck: Boolean) {
        sharedPrefDataSource.first = firstCheck
    }

    override fun checkLogin(): Boolean {
        return sharedPrefDataSource.checkLogin
    }

    override fun saveCheckLogin(checkLogin: Boolean) {
        sharedPrefDataSource.checkLogin = checkLogin
    }
}