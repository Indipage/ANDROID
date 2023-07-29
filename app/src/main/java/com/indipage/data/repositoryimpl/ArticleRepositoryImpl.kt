package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.ArticleDataSource
import com.indipage.domain.entity.ArticleAll
import com.indipage.domain.entity.ArticleSlide
import com.indipage.domain.entity.ArticleWeekly
import com.indipage.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val dataSource: ArticleDataSource
) : ArticleRepository {
    override suspend fun getArticleWeekly(): Result<ArticleWeekly?> {
        return runCatching {
            dataSource.getArticleWeekly().data?.toArticleWeeklyEntity()
        }
    }

    override suspend fun getArticleSlide(): Result<ArticleSlide?> {
        return runCatching {
            dataSource.getArticleSlide().data?.toArticleSlideEntity()
        }
    }

    override suspend fun putArticleSlide(): Result<Int> {
        return runCatching {
            dataSource.putArticleSlide().code
        }
    }

    override suspend fun getArticleAll(): Result<List<ArticleAll>?> {
        return runCatching {
            dataSource.getArticleAll().data?.map { it -> it.toArticleAllEntity() }
        }
    }
}