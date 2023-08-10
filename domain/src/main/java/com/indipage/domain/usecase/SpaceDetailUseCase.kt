package com.indipage.domain.usecase

import com.indipage.domain.model.Space
import com.indipage.domain.repository.BookMarkRepository
import kotlinx.coroutines.flow.Flow

class SpaceDetailUseCase(
    private val repository: SpaceDetailRepository
) {
    suspend fun getSpaceDetail(spaceId: Int): Result<SpaceDetail?> = repository.getSpaceDetail()
    suspend fun getCuration(spaceId: Int): Result<List<Curation>?> = repository.getCuration()
    suspend fun getBookmarked(spaceId: Int): Result<Boolean> = repository.getBookmarked()
    suspend fun postBookmarked(spaceId: Int): Result<Int> = repository.postBookmarked()
    suspend fun deleteBookmarked(spaceId: Int): Result<Int> = repository.deleteBookmarked()
    suspend fun getFollow(spaceId: Int): Result<Boolean> = repository.getFollow()
    suspend fun postFollow(spaceId: Int): Result<Int> = repository.postFollow()
    suspend fun getSpaceArticle(spaceId: Int): Result<SpaceArticle?> = repository.getSpaceArticle()
}