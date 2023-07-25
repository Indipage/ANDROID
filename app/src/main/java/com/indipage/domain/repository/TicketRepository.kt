package com.indipage.domain.repository

import com.indipage.data.dto.response.ResponseCardDto
import com.indipage.data.dto.response.ResponseQrDto
import com.indipage.domain.entity.TicketList

interface TicketRepository {

    suspend fun isCheckQR(spaceId: Int): Result<ResponseQrDto?>
    suspend fun getTicketList(): Result<TicketList?>
    suspend fun getCardList(): Result<List<ResponseCardDto>>
}