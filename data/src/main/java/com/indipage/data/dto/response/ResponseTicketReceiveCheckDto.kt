package com.indipage.data.dto.response

import com.indipage.domain.model.TicketEntity
import com.indipage.domain.model.TicketReceiveCheck
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.NotNull

@Serializable
data class ResponseTicketReceiveCheckDto(
    @SerialName("ticket") val ticket: Ticket,
    @SerialName("hasReceivedTicket") val hasReceivedTicket: Boolean
) {
    fun toTicketReceiveCheckEntity() =
        TicketReceiveCheck(ticket.toTicketEntity(), hasReceivedTicket)
}

@Serializable
data class Ticket(
     @SerialName("id") val id: Int,
     @SerialName("ticketImageUrl") val ticketImageUrl: String,
     @SerialName("cardImageUrl") val cardImageUrl: String,
     @SerialName("ticketForArticleImageUrl") val ticketForArticleImageUrl: String
) {
    fun toTicketEntity() = TicketEntity(id, ticketImageUrl, cardImageUrl, ticketForArticleImageUrl)
}

