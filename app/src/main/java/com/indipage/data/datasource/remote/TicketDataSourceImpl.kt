package com.indipage.data.datasource.remote

import com.indipage.data.api.TicketApiService
import com.indipage.data.datasource.TicketDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.ResponseCardDto
import com.indipage.data.dto.response.ResponseQrDto
import com.indipage.data.dto.response.ResponseTicketDto
import javax.inject.Inject

class TicketDataSourceImpl @Inject constructor(
    private val apiService: TicketApiService
) : TicketDataSource {

    override suspend fun isCheckQR(spaceId: Int): BaseResponseNullable<ResponseQrDto> {
        return apiService.isCheckQR(spaceId)
    }

    override suspend fun getTicketList(): ResponseTicketDto {
        return apiService.getTicketList()
    }

    override suspend fun getCardList(): BaseResponse<List<ResponseCardDto>> {
        return apiService.getCardList()
    }

}