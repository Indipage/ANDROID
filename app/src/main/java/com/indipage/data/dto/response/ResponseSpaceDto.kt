package com.indipage.data.dto.response

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ResponseSpaceDto(
    @SerialName("name")
    val name: String,
    @SerialName("roadAddress")
    val roadAddress: String,
    @SerialName("id")
    val id: Int,
    @SerialName("imageUrl")
    val imageUrl:String
)
