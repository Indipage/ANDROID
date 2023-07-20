package com.indipage.presentation.model

import com.indipage.domain.entity.UserInfo
data class UserInfoModel(
    val id: Long,
    val name: String,
    val email: String
)

fun UserInfo.toUserModelEntity() = UserInfoModel(
    id, name, email
)
