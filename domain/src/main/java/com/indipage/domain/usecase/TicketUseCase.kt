package com.indipage.domain.usecase


import com.indipage.domain.model.Card
import com.indipage.domain.model.Ticket
import com.indipage.domain.repository.TicketRepository

class TicketUseCase(
    private val repository: TicketRepository
) {
    suspend fun getTicketList(): Result<List<Ticket>?> =
        repository.getTicketList()

    suspend fun getCardList(): Result<List<Card>?> =
        repository.getCardList()

}