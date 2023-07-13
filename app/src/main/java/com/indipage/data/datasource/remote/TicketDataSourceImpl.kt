package com.indipage.data.datasource.remote

import com.indipage.data.api.UserApiService
import com.indipage.data.datasource.TicketDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.QRResponse
import javax.inject.Inject

class TicketDataSourceImpl @Inject constructor(
    private val apiService: UserApiService
) : TicketDataSource {

    override suspend fun isCheckQR(spaceId :Int): QRResponse {
        return apiService.isCheckQR(spaceId)
    }

}