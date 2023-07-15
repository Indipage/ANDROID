package com.indipage.data.dto.response

import com.indipage.domain.entity.Ticket
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseTicketDto(
    @SerialName("ticketId")
    val ticketId: Int,
    @SerialName("imageUrl")
    val imageUrl: Int,
    @SerialName("spaceId")
    val spaceId: Int,
)

fun ResponseTicketDto.toTicketEntity() = Ticket(
    ticketId, imageUrl, spaceId
)