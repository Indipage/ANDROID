package com.indipage.domain.repository

import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.data.dto.response.ResponseArticleBookmarkDto
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.data.dto.response.ResponseTicketReceiveCheckDto

interface ArticleDetailRepository {
    suspend fun getArticleDetail(articleId: Long): Result<ResponseArticleDetailDto>

    suspend fun getTicketReceiveCheck(spaceId: Long): Result<ResponseTicketReceiveCheckDto>

    suspend fun postTicketReceive(spaceId: Long): Result<Int>

    suspend fun getArticleAll(): Result<List<ResponseArticleAllDto>>

    suspend fun getBookmark(articleId: Long): Result<ResponseArticleBookmarkDto>

    suspend fun postBookmark(articleId: Long): Result<Int>

    suspend fun deleteBookmark(articleId: Long): Result<Int>

}