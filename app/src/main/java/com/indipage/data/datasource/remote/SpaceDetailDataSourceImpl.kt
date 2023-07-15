package com.indipage.data.datasource.remote

import com.indipage.data.api.SpaceDetailApiService
import com.indipage.data.datasource.SpaceDetailDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.QRResponse
import com.indipage.data.dto.response.BookmarkData
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.FollowData
import com.indipage.data.dto.response.SpaceArticleData
import com.indipage.data.dto.response.SpaceDetailData
import javax.inject.Inject

class SpaceDetailDataSourceImpl @Inject constructor(
    private val apiService: SpaceDetailApiService
) : SpaceDetailDataSource {
    override suspend fun getBookmarked(): BaseResponse<BookmarkData> {
        return apiService.getBookmarked(spaceId = 1)
    }

    override suspend fun deleteBookmarked(): QRResponse {
        return apiService.deleteBookmarked(spaceId = 1)
    }

    override suspend fun postBookmarked(): QRResponse {
        return apiService.postBookmarked(spaceId = 1)
    }

    override suspend fun getSpaceDetail(): BaseResponse<SpaceDetailData> {
        return apiService.getSpaceDetail(spaceId = 1)
    }

    override suspend fun getCuration(): BaseResponse<List<CurationData>> {
        return apiService.getCuration(spaceId = 1)
    }

    override suspend fun getFollow(): BaseResponse<FollowData> {
        return apiService.getFollow(spaceId = 1)
    }

    override suspend fun postFollow(): QRResponse {
        return apiService.postFollow(spaceId = 1)
    }

    override suspend fun getSpaceArticle(): BaseResponseNullable<SpaceArticleData> {
        return apiService.getSpaceArticle(spaceId = 1)
    }
}