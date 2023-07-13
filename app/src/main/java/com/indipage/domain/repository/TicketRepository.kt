package com.indipage.domain.repository

import com.indipage.data.dto.BaseResponse

interface TicketRepository {

    suspend fun isCheckQR(spaceId:Int): Result<Int>

}