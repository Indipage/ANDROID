package com.indipage.data.dto.response

import com.indipage.domain.entity.UserInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponseDto (
    @SerialName("id")
    val id: Long,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String,
)

fun UserResponseDto.toUserInfoEntity()=UserInfo(
    id, createdAt, name, email
)
