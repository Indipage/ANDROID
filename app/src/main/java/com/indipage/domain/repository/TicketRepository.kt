package com.indipage.domain.repository

import com.indipage.domain.entity.Card
import com.indipage.domain.entity.Ticket

interface TicketRepository {

    suspend fun isCheckQR(spaceId: Int): Result<Int>
    suspend fun getTicketList(): Result<Ticket>
    suspend fun getCardList(): Result<Card>
}