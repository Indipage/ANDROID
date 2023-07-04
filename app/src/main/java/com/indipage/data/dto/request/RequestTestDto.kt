package com.indipage.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestTestDto(
    @SerialName("test")
    val test: String
)