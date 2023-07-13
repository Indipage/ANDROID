package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.SpaceDetailDataSource
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.SpaceDetailData
import com.indipage.domain.repository.SpaceDetailRepository
import javax.inject.Inject

class SpaceDetailRepositoryImpl @Inject constructor(
    private val dataSource: SpaceDetailDataSource
) : SpaceDetailRepository {
    override suspend fun getSpaceDetail(): Result<SpaceDetailData> {
        return runCatching {
            dataSource.getSpaceDetail().data
        }
    }

    override suspend fun getCuration(): Result<List<CurationData>>{
        return runCatching {
            dataSource.getCuration().data
        }
    }
}