package com.indipage.data.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSignUpDto(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: SignUpData?
){
    @Serializable
    data class SignUpData(
        @SerialName("name")
        val name: String,
        @SerialName("skill")
        val skill: String,
    )
}

@Serializable
data class ResponseSignInDto(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: SignInData?
){
    @Serializable
    data class SignInData(
        @SerialName("id")
        val id: String?,
        @SerialName("name")
        val name: String,
        @SerialName("skill")
        val skill: String,
    )
}


