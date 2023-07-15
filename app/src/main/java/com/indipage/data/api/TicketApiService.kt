package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.QRResponse
import com.indipage.data.dto.response.ResponseTicketDto
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface TicketApiService {

    @GET("/user/ticket")
    suspend fun getTicketList(
    ): BaseResponse<ResponseTicketDto>

    @PUT("/user/space/{spaceId}/visit")
    suspend fun isCheckQR(
        @Path("spaceId") spaceId: Int
    ): QRResponse
}