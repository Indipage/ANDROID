package com.indipage.data.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseTestDto(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: SignInData?
){
    @Serializable
    data class SignInData(
        @SerialName("go")
        val go: String?
    )
}


