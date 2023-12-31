package com.indipage.domain.model

data class TicketReceiveCheck(
    val ticket: TicketEntity,
    val hasReceivedTicket: Boolean
)

data class TicketEntity(
    val id: Int,
    val ticketImageUrl: String,
    val cardImageUrl: String,
    val ticketForArticleImageUrl: String
)
