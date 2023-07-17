package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.ResponseCardDto
import com.indipage.data.dto.response.ResponseTicketDto

interface TicketDataSource {
    suspend fun isCheckQR(spaceId:Int): NullResponse
    suspend fun getTicketList(): BaseResponse<ResponseTicketDto>
    suspend fun getCardList(): BaseResponse<ResponseCardDto>
}