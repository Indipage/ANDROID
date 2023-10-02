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
    companion object{
        const val SPACE = "space"
        const val SPACE_ID = "spaceId"
        const val VISIT = "visit"
        const val USER = "user"
        const val CARD = "card"
        const val TICKET = "ticket"
    }

    @GET("/$USER/$TICKET")
    suspend fun getTicketList(): BaseResponseNullable<List<ResponseTicketDto>>

    @GET("/$USER/$CARD")
    suspend fun getCardList(
    ): BaseResponseNullable<List<ResponseCardDto>>

    @PATCH("/$SPACE/{$SPACE_ID}/$VISIT")
    suspend fun isCheckQR(
        @Path("$SPACE_ID") spaceId: Int
    ): BaseResponseNullable<ResponseQrDto>
}