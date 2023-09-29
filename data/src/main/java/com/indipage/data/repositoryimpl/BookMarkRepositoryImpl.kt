package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.BookMarkDataSource
import com.indipage.domain.Outcome
import com.indipage.domain.model.Article
import com.indipage.domain.model.Space
import com.indipage.domain.repository.BookMarkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BookMarkRepositoryImpl @Inject constructor(
    private val dataSource: BookMarkDataSource
) : BookMarkRepository {
    override suspend fun getSavedArticles(): Flow<Outcome<List<Article>?>> {
        return flow {
            val result = kotlin.runCatching {
                dataSource.getSavedArticles().data?.map { it.toArticleEntity() }
            }
            if(result.isSuccess){
                emit(Outcome.Success(result.getOrDefault(emptyList())))
            }else{
                emit(Outcome.Failure(error = null))
            }
        }
    }

    override suspend fun getSavedSpaces(): Flow<List<Space>?> {
        return flow {
            val result = kotlin.runCatching {
                dataSource.getSavedSpaces().data?.map { spaceDto->spaceDto.toSpaceEntity() }
            }
            emit(result.getOrDefault(emptyList()))
        }
    }


}