package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.TicketDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.toCardEntity
import com.indipage.data.dto.response.toTicketEntity
import com.indipage.domain.entity.Card
import com.indipage.domain.entity.Ticket
import com.indipage.domain.repository.TicketRepository
import javax.inject.Inject

class TicketRepositoryImpl @Inject constructor(
    private val dataSource: TicketDataSource
) : TicketRepository {

    override suspend fun isCheckQR(spaceId: Int): Result<Int> {
        return kotlin.runCatching {
            dataSource.isCheckQR(spaceId).code
        }
    }

    override suspend fun getTicketList(): Result<Ticket> {
        return kotlin.runCatching {
            dataSource.getTicketList().data.toTicketEntity()
        }
    }

    override suspend fun getCardList(): Result<Card> {
        return kotlin.runCatching {
            dataSource.getCardList().data.toCardEntity()
        }
    }
}