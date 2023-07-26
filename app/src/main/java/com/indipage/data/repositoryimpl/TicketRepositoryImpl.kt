package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.TicketDataSource
import com.indipage.data.dto.response.ResponseCardDto
import com.indipage.data.dto.response.ResponseQrDto
import com.indipage.domain.entity.Card
import com.indipage.domain.entity.Ticket
import com.indipage.domain.repository.TicketRepository
import javax.inject.Inject

class TicketRepositoryImpl @Inject constructor(
    private val dataSource: TicketDataSource
) : TicketRepository {

    override suspend fun isCheckQR(spaceId: Int): Result<ResponseQrDto?> {
        return kotlin.runCatching {
            dataSource.isCheckQR(spaceId).data
        }
    }

    override suspend fun getTicketList(): Result<List<Ticket>?> {
        return kotlin.runCatching {
            dataSource.getTicketList().data?.map { ticketDto -> ticketDto.toTicketEntity() }
        }
    }

    override suspend fun getCardList(): Result<List<Card>?> {
        return kotlin.runCatching {
            dataSource.getCardList().data?.map { cardDto->cardDto.toCardEntity() }
        }
    }
}