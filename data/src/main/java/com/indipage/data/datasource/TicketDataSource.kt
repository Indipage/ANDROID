package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.response.ResponseCardDto
import com.indipage.data.dto.response.ResponseQrDto
import com.indipage.data.dto.response.ResponseTicketDto

interface TicketDataSource {
    suspend fun isCheckQR(spaceId:Int): BaseResponseNullable<ResponseQrDto>
    suspend fun getTicketList(): BaseResponseNullable<List<ResponseTicketDto>>
    suspend fun getCardList(): BaseResponseNullable<List<ResponseCardDto>>
}