package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.ArticleDataSource
import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.data.dto.response.ResponseArticleSlideDto
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

    override suspend fun getArticleSlide(): Result<ResponseArticleSlideDto> {
        return runCatching {
            dataSource.getArticleSlide().data
        }
    }

    override suspend fun putArticleSlide(): Result<Int> {
        return runCatching {
            dataSource.putArticleSlide().code
        }
    }

    override suspend fun getArticleAll(): Result<List<ResponseArticleAllDto>?> {
        return runCatching {
            dataSource.getArticleAll().data
        }
    }
}