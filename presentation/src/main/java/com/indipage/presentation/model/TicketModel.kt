package com.indipage.presentation.model

import com.indipage.domain.model.Ticket


data class TicketModel (
    val ticketId:Int,
    val imageUrl:String,
    val spaceId:Int
    )

fun Ticket.toTicketModelEntity()= TicketModel(
    ticketId,imageUrl, spaceId
)