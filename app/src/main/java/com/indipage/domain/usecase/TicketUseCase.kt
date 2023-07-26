package com.indipage.domain.usecase

import com.indipage.domain.entity.Card
import com.indipage.domain.entity.Ticket
import com.indipage.domain.repository.TicketRepository

class TicketUseCase (
    private val repository: TicketRepository
) {
    suspend fun getTicketList(): Result<List<Ticket>?> {
        return repository.getTicketList()
    }

    suspend fun getCardList(): Result<List<Card>?>{
        return repository.getCardList()
    }
}