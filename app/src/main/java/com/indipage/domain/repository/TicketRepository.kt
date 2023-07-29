package com.indipage.domain.repository

import com.indipage.domain.entity.Card
import com.indipage.domain.entity.MainCard
import com.indipage.domain.entity.Ticket

interface TicketRepository {

    suspend fun isCheckQR(spaceId: Int): Result<MainCard?>
    suspend fun getTicketList(): Result<List<Ticket>?>
    suspend fun getCardList(): Result<List<Card>?>
}