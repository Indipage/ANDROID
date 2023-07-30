package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.BookMarkDataSource
import com.indipage.domain.model.Article
import com.indipage.domain.model.Space
import com.indipage.domain.repository.BookMarkRepository
import javax.inject.Inject

class BookMarkRepositoryImpl @Inject constructor(
    private val dataSource: BookMarkDataSource
) : BookMarkRepository {
    override suspend fun getSavedArticles(): Result<List<Article>?> {
        return runCatching {
            dataSource.getSavedArticles().data?.map { articleDto -> articleDto.toArticleEntity() }
        }
    }

    override suspend fun getSavedSpaces(): Result<List<Space>?> {
        return runCatching {
            dataSource.getSavedSpaces().data?.map { spaceDto -> spaceDto.toSpaceEntity() }
        }
    }
}