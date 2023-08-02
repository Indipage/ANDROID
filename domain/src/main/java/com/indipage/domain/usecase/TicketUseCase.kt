package com.indipage.domain.usecase


import com.indipage.domain.model.Card
import com.indipage.domain.model.Ticket
import com.indipage.domain.repository.TicketRepository
import kotlinx.coroutines.flow.Flow

class TicketUseCase(
    private val repository: TicketRepository
) {
    suspend fun getTicketList(): Flow<List<Ticket>?> =
        repository.getTicketList()

    suspend fun getCardList(): Flow<List<Card>?> =
        repository.getCardList()

}