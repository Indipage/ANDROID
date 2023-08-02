package com.indipage.domain.usecase


import com.indipage.domain.model.Card
import com.indipage.domain.repository.TicketRepository
import kotlinx.coroutines.flow.Flow

class CardUseCase(
    private val repository: TicketRepository
) {

    suspend operator fun invoke(): Flow<List<Card>?> =
        repository.getCardList()

}