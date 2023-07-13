package com.indipage.presentation.model

import com.indipage.data.dto.response.UserResponseDto
import com.indipage.domain.entity.UserInfo

data class UserInfoModel (
    val id: Long,
    val createdAt: String,
    val name: String,
    val email: String
)

fun UserInfo.toUserModelEntity()= UserInfoModel(
    id, createdAt, name, email
)
