package com.indipage.data.datasource.remote

import com.indipage.data.api.TicketApiService
import com.indipage.data.datasource.TicketDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.QRResponse
import com.indipage.data.dto.response.ResponseTicketDto
import javax.inject.Inject

class TicketDataSourceImpl @Inject constructor(
    private val apiService: TicketApiService
) : TicketDataSource {

    override suspend fun isCheckQR(spaceId :Int): QRResponse {
        return apiService.isCheckQR(spaceId)
    }

    override suspend fun getTicketList(): BaseResponse<ResponseTicketDto> {
        return apiService.getTicketList()
    }

}