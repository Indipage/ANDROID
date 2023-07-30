package com.indipage.domain.repository

import com.indipage.domain.model.ArticleBookmark
import com.indipage.domain.model.ArticleDetail
import com.indipage.domain.model.TicketReceiveCheck

interface ArticleDetailRepository {
    suspend fun getArticleDetail(articleId: Long): Result<ArticleDetail?>

    suspend fun getTicketReceiveCheck(spaceId: Long): Result<TicketReceiveCheck?>

    suspend fun postTicketReceive(spaceId: Long): Result<Int>

    suspend fun getBookmark(articleId: Long): Result<ArticleBookmark?>

    suspend fun postBookmark(articleId: Long): Result<Int>

    suspend fun deleteBookmark(articleId: Long): Result<Int>

}