package com.indipage.data.dto.response

import com.indipage.data.dto.BaseResponseNullable
import com.indipage.domain.entity.Ticket
import com.indipage.domain.entity.TicketList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseTicketDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<TicketDto>,
) {
    fun toTicketListEntity() = TicketList(data.map { it.toTicketEntity() })
}

@Serializable
data class TicketDto(
    @SerialName("ticketId")
    val ticketId: Int,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("spaceId")
    val spaceId: Int,
) {
    fun toTicketEntity() = Ticket(
        ticketId, imageUrl, spaceId
    )
}


