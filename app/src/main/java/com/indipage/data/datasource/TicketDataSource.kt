package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.QRResponse
import com.indipage.data.dto.response.ResponseTicketDto
import com.indipage.data.dto.response.UserResponseDto

interface TicketDataSource {
    suspend fun isCheckQR(spaceId:Int): QRResponse

    suspend fun getTicketList(): BaseResponse<ResponseTicketDto>
}