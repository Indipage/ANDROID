package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.ResponseCardDto
import com.indipage.data.dto.response.ResponseQrDto
import com.indipage.data.dto.response.ResponseTicketDto

interface TicketDataSource {
    suspend fun isCheckQR(spaceId:Int): BaseResponseNullable<ResponseQrDto>
    suspend fun getTicketList(): ResponseTicketDto
    suspend fun getCardList(): BaseResponse<List<ResponseCardDto>>
}