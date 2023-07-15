package com.indipage.presentation.model

import com.indipage.domain.entity.Ticket
import com.indipage.domain.entity.UserInfo

data class TicketModel (
    val ticketId:Int,
    val imageUrl:Int,
    val spaceId:Int
    )

fun Ticket.toTicketModelEntity()= TicketModel(
    ticketId,imageUrl, spaceId
)