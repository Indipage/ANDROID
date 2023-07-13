package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.ArticleDetailDataSource
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.domain.repository.ArticleDetailRepository
import javax.inject.Inject

class ArticleDetailRepositoryImpl @Inject constructor(
    private val dataSource: ArticleDetailDataSource
) : ArticleDetailRepository {
    override suspend fun getArticleDetail(articleId: Long): Result<ResponseArticleDetailDto> {
        return runCatching {
            dataSource.getArticleDetail(articleId).data
        }
    }
}
