package com.indipage.data.datasource.remote

import com.indipage.data.api.SpaceDetailApiService
import com.indipage.data.datasource.SpaceDetailDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.BookmarkData
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.FollowData
import com.indipage.data.dto.response.SpaceArticleData
import com.indipage.data.dto.response.SpaceDetailData
import javax.inject.Inject

class SpaceDetailDataSourceImpl @Inject constructor(
    private val apiService: SpaceDetailApiService
) : SpaceDetailDataSource {

    override suspend fun getBookmarked(spaceId: Int): BaseResponse<BookmarkData> {
        return apiService.getBookmarked(spaceId)
    }

    override suspend fun deleteBookmarked(spaceId: Int): NullResponse {
        return apiService.deleteBookmarked(spaceId)
    }

    override suspend fun postBookmarked(spaceId: Int): NullResponse {
        return apiService.postBookmarked(spaceId)
    }

    override suspend fun getSpaceDetail(spaceId: Int): BaseResponseNullable<SpaceDetailData> {
        return apiService.getSpaceDetail(spaceId)
    }

    override suspend fun getCuration(spaceId: Int): BaseResponseNullable<List<CurationData>> {
        return apiService.getCuration(spaceId)
    }

    override suspend fun getFollow(spaceId: Int): BaseResponse<FollowData> {
        return apiService.getFollow(spaceId)
    }

    override suspend fun postFollow(spaceId: Int): NullResponse {
        return apiService.postFollow(spaceId)
    }

    override suspend fun getSpaceArticle(spaceId: Int): BaseResponseNullable<SpaceArticleData> {
        return apiService.getSpaceArticle(spaceId)
    }

}