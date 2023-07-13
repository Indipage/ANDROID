package com.indipage.data.datasource.remote

import com.indipage.data.api.SpaceDetailApiService
import com.indipage.data.datasource.SpaceDetailDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.SpaceDetailData
import javax.inject.Inject

class SpaceDetailDataSourceImpl @Inject constructor(
    private val apiService: SpaceDetailApiService
) : SpaceDetailDataSource {
    override suspend fun getSpaceDetail(): BaseResponse<SpaceDetailData> {
        return apiService.getSpaceDetail(spaceId = 1)
    }

    override suspend fun getCuration(): BaseResponse<List<CurationData>> {
        return apiService.getCuration(spaceId = 1)
    }
}