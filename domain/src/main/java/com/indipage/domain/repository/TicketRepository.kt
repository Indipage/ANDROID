package com.indipage.domain.repository

import com.indipage.domain.model.Card
import com.indipage.domain.model.MainCard
import com.indipage.domain.model.Ticket


interface TicketRepository {

    suspend fun isCheckQR(spaceId: Int): Result<MainCard?>
    suspend fun getTicketList(): Result<List<Ticket>?>
    suspend fun getCardList(): Result<List<Card>?>
}