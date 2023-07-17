package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.data.dto.response.ResponseArticleBookmarkDto
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.data.dto.response.ResponseTicketReceiveCheckDto

interface ArticleDetailDataSource {
    suspend fun getArticleDetail(articleId: Long): BaseResponse<ResponseArticleDetailDto>

    suspend fun getTicketReceiveCheck(spaceId: Long): BaseResponse<ResponseTicketReceiveCheckDto>

    suspend fun postTicketReceive(spaceId: Long): NullResponse

    suspend fun getArticleAll(): BaseResponse<List<ResponseArticleAllDto>>

    suspend fun getBookmark(articleId: Long): BaseResponse<ResponseArticleBookmarkDto>

    suspend fun postBookmark(articleId: Long): NullResponse
}