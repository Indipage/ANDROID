package com.indipage.data.dto.response

import com.indipage.domain.model.Ticket
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//@Serializable
//data class ResponseTicketDto(
//    @SerialName("code")
//    val code: Int,
//    @SerialName("message")
//    val message: String,
//    @SerialName("data")
//    val ticketDtos: List<TicketDto>,
//) {
//    fun toTicketListEntity() = TicketList(ticketDtos.map { it.toTicketEntity()})
//}

@Serializable
data class ResponseTicketDto(
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


