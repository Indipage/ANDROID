package com.indipage.domain.repository

import com.indipage.data.dto.response.BookmarkData
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.FollowData
import com.indipage.data.dto.response.SpaceArticleData
import com.indipage.data.dto.response.SpaceDetailData

interface SpaceDetailRepository {
    suspend fun getSpaceDetail(): Result<SpaceDetailData>
    suspend fun getCuration(): Result<List<CurationData>>
    suspend fun getBookmarked(): Result<BookmarkData>
    suspend fun postBookmarked(): Result<Int>
    suspend fun deleteBookmarked(): Result<Int>
    suspend fun getFollow(): Result<FollowData>
    suspend fun postFollow(): Result<Int>
    suspend fun getSpaceArticle(): Result<SpaceArticleData?>

}