package com.indipage.domain.repository

import com.indipage.data.dto.response.ResponseArticleBookmarkDto
import com.indipage.data.dto.response.ResponseTicketReceiveCheckDto
import com.indipage.domain.entity.ArticleDetail

interface ArticleDetailRepository {
    suspend fun getArticleDetail(articleId: Long): Result<ArticleDetail?>

    suspend fun getTicketReceiveCheck(spaceId: Long): Result<ResponseTicketReceiveCheckDto>

    suspend fun postTicketReceive(spaceId: Long): Result<Int>

    suspend fun getBookmark(articleId: Long): Result<ResponseArticleBookmarkDto>

    suspend fun postBookmark(articleId: Long): Result<Int>

    suspend fun deleteBookmark(articleId: Long): Result<Int>

}