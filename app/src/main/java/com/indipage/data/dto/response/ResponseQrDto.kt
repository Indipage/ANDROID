package com.indipage.data.dto.response

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ResponseQrDto(
    @SerialName("cardImageUrl") val cardImageUrl: String
)