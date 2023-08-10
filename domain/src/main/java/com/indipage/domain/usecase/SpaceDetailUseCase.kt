package com.indipage.domain.usecase

import com.indipage.domain.model.Curation
import com.indipage.domain.model.SpaceArticle
import com.indipage.domain.model.SpaceDetail
import com.indipage.domain.repository.SpaceDetailRepository

class SpaceDetailUseCase(
    private val repository: SpaceDetailRepository
) {
    suspend fun getSpaceDetail(spaceId: Int): Result<SpaceDetail?> =
        repository.getSpaceDetail(spaceId)

    suspend fun getCuration(spaceId: Int): Result<List<Curation>?> = repository.getCuration(spaceId)
    suspend fun getBookmarked(spaceId: Int): Result<Boolean> = repository.getBookmarked(spaceId)
    suspend fun postBookmarked(spaceId: Int): Result<Int> = repository.postBookmarked(spaceId)
    suspend fun deleteBookmarked(spaceId: Int): Result<Int> = repository.deleteBookmarked(spaceId)
    suspend fun getFollow(spaceId: Int): Result<Boolean> = repository.getFollow(spaceId)
    suspend fun postFollow(spaceId: Int): Result<Int> = repository.postFollow(spaceId)
    suspend fun getSpaceArticle(spaceId: Int): Result<SpaceArticle?> =
        repository.getSpaceArticle(spaceId)
}