package com.indipage.domain.repository

import com.indipage.data.dto.BaseResponse
import com.indipage.domain.entity.Ticket

interface TicketRepository {

    suspend fun isCheckQR(spaceId:Int): Result<Int>
    suspend fun getTicketList():Result<Ticket>

}