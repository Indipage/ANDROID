package com.indipage.domain.repository

interface AuthRepository {
    fun saveAccessToken(a: String)
    fun getAccessToken(): String

}