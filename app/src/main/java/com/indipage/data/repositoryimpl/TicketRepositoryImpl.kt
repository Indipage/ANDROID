package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.TicketDataSource
import com.indipage.data.dto.BaseResponse
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
}