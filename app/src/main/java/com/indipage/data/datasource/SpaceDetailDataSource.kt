package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.QRResponse
import com.indipage.data.dto.response.BookmarkData
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.FollowData
import com.indipage.data.dto.response.SpaceArticleData
import com.indipage.data.dto.response.SpaceDetailData

interface SpaceDetailDataSource {
    suspend fun getBookmarked(): BaseResponse<BookmarkData>
    suspend fun deleteBookmarked(): QRResponse
    suspend fun postBookmarked(): QRResponse
    suspend fun getSpaceDetail(): BaseResponse<SpaceDetailData>
    suspend fun getCuration(): BaseResponse<List<CurationData>>
    suspend fun postFollow(): QRResponse
    suspend fun getFollow(): BaseResponse<FollowData>
    suspend fun getSpaceArticle(): BaseResponseNullable<SpaceArticleData>
}