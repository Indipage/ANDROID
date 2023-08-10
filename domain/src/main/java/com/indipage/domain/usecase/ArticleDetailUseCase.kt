package com.indipage.domain.usecase

import com.indipage.domain.model.ArticleBookmark
import com.indipage.domain.model.ArticleDetail
import com.indipage.domain.model.TicketReceiveCheck
import com.indipage.domain.repository.ArticleDetailRepository

class ArticleDetailUseCase(
    private val repository: ArticleDetailRepository
) {
    suspend fun getArticleDetail(articleId: Long): Result<ArticleDetail?> =
        repository.getArticleDetail(articleId)

    suspend fun getTicketReceiveCheck(spaceId: Long): Result<TicketReceiveCheck?> =
        repository.getTicketReceiveCheck(spaceId)

    suspend fun postTicketReceive(spaceId: Long): Result<Int> =
        repository.postTicketReceive(spaceId)

    suspend fun getBookmark(articleId: Long): Result<ArticleBookmark?> =
        repository.getBookmark(articleId)

    suspend fun postBookmark(articleId: Long): Result<Int> = repository.postBookmark(articleId)

    suspend fun deleteBookmark(articleId: Long): Result<Int> = repository.deleteBookmark(articleId)

}