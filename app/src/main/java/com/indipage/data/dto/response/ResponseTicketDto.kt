package com.indipage.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseTicketDto(
    @SerialName("ticket")
    val ticket: List<Ticket>,
    @SerialName("hasReceivedTicket")
    val hasReceivedTicket: Boolean
) {

    @Serializable
    data class Ticket(
        @SerialName("id")
        val id: Int,
        @SerialName("ticketImageUrl")
        val ticketImageUrl: String,
        @SerialName("cardImageUrl")
        val cardImageUrl: String
    )

}