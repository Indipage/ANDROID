package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.SharedPreferencesDataSource
import com.indipage.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPrefDataSource: SharedPreferencesDataSource
) : AuthRepository {
    override fun saveAccessToken(a: String) {
        sharedPrefDataSource.accessToken = a
    }

    override fun getAccessToken(): String {
        return sharedPrefDataSource.accessToken ?: ""
    }

}