package com.indipage.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ResponseSignInDto(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String,
    @SerialName("skill")
    val skill: String,
)



