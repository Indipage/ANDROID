package com.indipage.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestTicketReceiveDto(
    @SerialName("spaceId")
    val spaceId: Int
)
