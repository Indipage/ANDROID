package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.UserResponseDto

interface TicketDataSource {
    suspend fun isCheckQR(spaceId:Int): BaseResponse<String>
}