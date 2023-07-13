package com.indipage.domain.repository

import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.SpaceDetailData

interface SpaceDetailRepository {
    suspend fun getSpaceDetail(): Result<SpaceDetailData>
    suspend fun getCuration(): Result<List<CurationData>>
}