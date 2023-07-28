package com.indipage.domain.repository

import com.indipage.domain.entity.Curation
import com.indipage.domain.entity.SpaceArticle
import com.indipage.domain.entity.SpaceDetail

interface SpaceDetailRepository {
    suspend fun getSpaceDetail(spaceId: Int): Result<SpaceDetail?>
    suspend fun getCuration(spaceId: Int): Result<List<Curation>?>
    suspend fun getBookmarked(spaceId: Int): Result<Boolean>
    suspend fun postBookmarked(spaceId: Int): Result<Int>
    suspend fun deleteBookmarked(spaceId: Int): Result<Int>
    suspend fun getFollow(spaceId: Int): Result<Boolean>
    suspend fun postFollow(spaceId: Int): Result<Int>
    suspend fun getSpaceArticle(spaceId: Int): Result<SpaceArticle?>

}