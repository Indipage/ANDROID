package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.BookmarkData
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.FollowData
import com.indipage.data.dto.response.SpaceArticleData
import com.indipage.data.dto.response.SpaceDetailData

interface SpaceDetailDataSource {
    suspend fun getBookmarked(spaceId:Int): BaseResponse<BookmarkData>
    suspend fun deleteBookmarked(spaceId:Int): NullResponse
    suspend fun postBookmarked(spaceId:Int): NullResponse
    suspend fun getSpaceDetail(spaceId:Int): BaseResponse<SpaceDetailData>
    suspend fun getCuration(spaceId:Int): BaseResponse<List<CurationData>>
    suspend fun postFollow(spaceId:Int): NullResponse
    suspend fun getFollow(spaceId:Int): BaseResponse<FollowData>
    suspend fun getSpaceArticle(spaceId:Int): BaseResponseNullable<SpaceArticleData>
}