package com.indipage.domain.repository

import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.data.dto.response.ResponseTicketReceiveCheckDto

interface ArticleDetailRepository {
    suspend fun getArticleDetail(articleId: Long): Result<ResponseArticleDetailDto>
    suspend fun getTicketReceiveCheck(spaceId: Long): Result<ResponseTicketReceiveCheckDto>
}