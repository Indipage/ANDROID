package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.response.ResponseCardDto
import com.indipage.data.dto.response.ResponseQrDto
import com.indipage.data.dto.response.ResponseTicketDto
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface TicketApiService {
    @GET("/user/ticket")
    suspend fun getTicketList(): BaseResponseNullable<List<ResponseTicketDto>>

    @GET("/user/card")
    suspend fun getCardList(
    ): BaseResponseNullable<List<ResponseCardDto>>

    @PATCH("/space/{spaceId}/visit")
    suspend fun isCheckQR(
        @Path("spaceId") spaceId: Int
    ): BaseResponseNullable<ResponseQrDto>
}