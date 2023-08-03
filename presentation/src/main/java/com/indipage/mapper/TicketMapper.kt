package com.indipage.mapper

import com.indipage.domain.model.Ticket
import com.indipage.model.TicketModel

fun List<Ticket>.toTicketModelEntity(): List<TicketModel> = map {
    TicketModel(
        ticketId = it.ticketId,
        imageUrl = it.imageUrl,
        spaceId = it.spaceId
    )
}