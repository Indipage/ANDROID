package com.indipage.domain.repository

import com.indipage.data.dto.response.BookmarkData
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.FollowData
import com.indipage.data.dto.response.SpaceArticleData
import com.indipage.data.dto.response.SpaceDetailData

interface SpaceDetailRepository {
    suspend fun getSpaceDetail(spaceId:Int): Result<SpaceDetailData>
    suspend fun getCuration(spaceId:Int): Result<List<CurationData>>
    suspend fun getBookmarked(spaceId:Int): Result<BookmarkData>
    suspend fun postBookmarked(spaceId:Int): Result<Int>
    suspend fun deleteBookmarked(spaceId:Int): Result<Int>
    suspend fun getFollow(spaceId:Int): Result<FollowData>
    suspend fun postFollow(spaceId:Int): Result<Int>
    suspend fun getSpaceArticle(spaceId:Int): Result<SpaceArticleData?>

}