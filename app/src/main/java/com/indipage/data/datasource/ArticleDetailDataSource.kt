package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.data.dto.response.ResponseTicketDto

interface ArticleDetailDataSource {
    suspend fun getArticleDetail(articleId: Long): BaseResponse<ResponseArticleDetailDto>

    suspend fun getTicketReceiveCheck(spaceId: Long): BaseResponse<ResponseTicketDto>
}