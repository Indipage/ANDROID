package com.indipage.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.NotNull

@Serializable
data class ResponseTicketReceiveCheckDto(
    @SerialName("ticket")
    val ticket: Ticket,
    @NotNull
    @SerialName("hasReceivedTicket")
    val hasReceivedTicket: Boolean
) {

    @Serializable
    data class Ticket(
        @NotNull
        @SerialName("id")
        val id: Int,
        @NotNull
        @SerialName("ticketImageUrl")
        val ticketImageUrl: String,
        @NotNull
        @SerialName("cardImageUrl")
        val cardImageUrl: String,
        @NotNull
        @SerialName("ticketForArticleImageUrl")
        val ticketForArticleImageUrl: String
    )

}