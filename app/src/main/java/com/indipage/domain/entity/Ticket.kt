package com.indipage.domain.entity


data class TicketList(
    val ticketList: List<Ticket>
)
data class Ticket(
    val ticketId:Int,
    val imageUrl:String,
    val spaceId:Int
)