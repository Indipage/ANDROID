package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.SpaceDetailData

interface SpaceDetailDataSource {
    suspend fun getSpaceDetail(): BaseResponse<SpaceDetailData>
    suspend fun getCuration(): BaseResponse<List<CurationData>>
}