package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.TicketDataSource
import com.indipage.domain.model.Card
import com.indipage.domain.model.MainCard
import com.indipage.domain.model.Ticket
import com.indipage.domain.repository.TicketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TicketRepositoryImpl @Inject constructor(
    private val dataSource: TicketDataSource
) : TicketRepository {

    override suspend fun isCheckQR(spaceId: Int): Result<MainCard?> {
        return kotlin.runCatching {
            dataSource.isCheckQR(spaceId).data?.toMainCardEntity()
        }
    }

    override suspend fun getTicketList(): Flow<List<Ticket>?> {
        return flow {
            val result = runCatching {
                dataSource.getTicketList().data?.map { ticketDto -> ticketDto.toTicketEntity() }
            }
            emit(result.getOrDefault(emptyList()))
        }

    }

    override suspend fun getCardList(): Flow<List<Card>?> {
        return flow {
            val result = runCatching {
                dataSource.getCardList().data?.map { cardDto -> cardDto.toCardEntity() }
            }
            emit(result.getOrDefault(emptyList()))
        }
    }
}