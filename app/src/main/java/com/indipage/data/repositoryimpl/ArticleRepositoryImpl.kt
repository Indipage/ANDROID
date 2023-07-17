package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.ArticleDataSource
import com.indipage.data.dto.response.ResponseArticleWeeklyDto
import com.indipage.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val dataSource: ArticleDataSource
) : ArticleRepository {
    override suspend fun getArticleWeekly(): Result<ResponseArticleWeeklyDto> {
        return runCatching {
            dataSource.getArticleWeekly().data
        }
    }
}