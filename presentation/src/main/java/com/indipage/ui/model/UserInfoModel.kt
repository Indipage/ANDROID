package com.indipage.ui.model

import com.indipage.domain.model.UserInfo

data class UserInfoModel(
    val id: Long,
    val name: String,
    val email: String
)

fun UserInfo.toUserModelEntity() = UserInfoModel(
    id, name, email
)
