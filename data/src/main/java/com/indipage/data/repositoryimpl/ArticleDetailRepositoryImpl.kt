package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.ArticleDetailDataSource
import com.indipage.domain.model.ArticleBookmark
import com.indipage.domain.model.ArticleDetail
import com.indipage.domain.model.TicketReceiveCheck
import com.indipage.domain.repository.ArticleDetailRepository
import javax.inject.Inject

class ArticleDetailRepositoryImpl @Inject constructor(
    private val dataSource: ArticleDetailDataSource
) : ArticleDetailRepository {
    override suspend fun getArticleDetail(articleId: Long): Result<ArticleDetail?> {
        return runCatching {
            dataSource.getArticleDetail(articleId).data?.toArticleDetailEntity()
        }
    }

    override suspend fun getTicketReceiveCheck(spaceId: Long): Result<TicketReceiveCheck?> {
        return runCatching {
            dataSource.getTicketReceiveCheck(spaceId).data?.toTicketReceiveCheckEntity()
        }
    }

    override suspend fun postTicketReceive(spaceId: Long): Result<Int> {
        return runCatching {
            dataSource.postTicketReceive(spaceId).code
        }
    }

    override suspend fun getBookmark(articleId: Long): Result<ArticleBookmark?> {
        return runCatching {
            dataSource.getBookmark(articleId).data?.toArticleBookmarkEntity()
        }
    }

    override suspend fun postBookmark(articleId: Long): Result<Int> {
        return runCatching {
            dataSource.postBookmark(articleId).code
        }
    }

    override suspend fun deleteBookmark(articleId: Long): Result<Int> {
        return runCatching {
            dataSource.deleteBookmark(articleId).code
        }
    }
}
