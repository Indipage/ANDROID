package com.indipage.domain.usecase


import com.indipage.domain.model.Ticket
import com.indipage.domain.repository.TicketRepository
import kotlinx.coroutines.flow.Flow

class TicketUseCase(
    private val repository: TicketRepository
) {
    suspend operator fun invoke(): Flow<List<Ticket>?> =
        repository.getTicketList()

}