package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.ResponseCardDto
import com.indipage.data.dto.response.ResponseTicketDto
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface TicketApiService {
    @GET("/user/ticket")
    suspend fun getTicketList(
    ): BaseResponse<ResponseTicketDto>

    @GET("/user/card")
    suspend fun getCardList(
    ): BaseResponse<ResponseCardDto>

    @PUT("/user/space/{spaceId}/visit")
    suspend fun isCheckQR(
        @Path("spaceId") spaceId: Int
    ): NullResponse
}