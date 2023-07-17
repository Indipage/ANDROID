package com.indipage.domain.repository

import com.indipage.data.dto.response.ResponseCardDto
import com.indipage.data.dto.response.ResponseTicketDto
import com.indipage.domain.entity.Card
import com.indipage.domain.entity.Ticket

interface TicketRepository {

    suspend fun isCheckQR(spaceId: Int): Result<Int>
    suspend fun getTicketList(): Result<List<ResponseTicketDto>>
    suspend fun getCardList(): Result<List<ResponseCardDto>>
}