package com.indipage.domain.repository

interface AuthRepository {
    fun saveAccessToken(accessToken: String)
    fun getAccessToken(): String

    fun getFirst(): Boolean
    fun saveFirst(firstCheck: Boolean)

    fun checkLogin(): Boolean
    fun saveCheckLogin(checkLogin: Boolean)
}