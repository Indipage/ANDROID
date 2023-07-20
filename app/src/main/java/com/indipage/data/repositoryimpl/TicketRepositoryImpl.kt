package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.TicketDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.*
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

    override suspend fun getTicketList(): Result<List<ResponseTicketDto>> {
        return kotlin.runCatching {
            dataSource.getTicketList().data
        }
    }

    override suspend fun getCardList(): Result<List<ResponseCardDto>> {
        return kotlin.runCatching {
            dataSource.getCardList().data
        }
    }
}