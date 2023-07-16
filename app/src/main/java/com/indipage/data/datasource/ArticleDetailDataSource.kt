package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.QRResponse
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.data.dto.response.ResponseTicketReceiveCheckDto

interface ArticleDetailDataSource {
    suspend fun getArticleDetail(articleId: Long): BaseResponse<ResponseArticleDetailDto>

    suspend fun getTicketReceiveCheck(spaceId: Long): BaseResponse<ResponseTicketReceiveCheckDto>

    suspend fun postTicketReceive(spaceId: Int): QRResponse
}