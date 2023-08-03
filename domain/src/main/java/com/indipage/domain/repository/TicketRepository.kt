package com.indipage.domain.repository

import com.indipage.domain.model.Card
import com.indipage.domain.model.MainCard
import com.indipage.domain.model.Ticket
import kotlinx.coroutines.flow.Flow


interface TicketRepository {

    suspend fun isCheckQR(spaceId: Int): Result<MainCard?>
    suspend fun getTicketList(): Flow<List<Ticket>?>
    suspend fun getCardList(): Flow<List<Card>?>
}