package com.indipage.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSpaceDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("imageUrl")
    val imageUrl:String ?="",
    @SerialName("address")
    val roadAddress: String,
)
