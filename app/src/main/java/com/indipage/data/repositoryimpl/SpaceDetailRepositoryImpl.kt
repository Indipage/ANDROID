package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.SpaceDetailDataSource
import com.indipage.data.dto.response.BookmarkData
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.FollowData
import com.indipage.data.dto.response.SpaceArticleData
import com.indipage.data.dto.response.SpaceDetailData
import com.indipage.domain.repository.SpaceDetailRepository
import javax.inject.Inject

class SpaceDetailRepositoryImpl @Inject constructor(
    private val dataSource: SpaceDetailDataSource
) : SpaceDetailRepository {

    override suspend fun getBookmarked(): Result<BookmarkData> {
        return runCatching {
            dataSource.getBookmarked().data
        }
    }

    override suspend fun postBookmarked(): Result<Int> {
        return runCatching {
            dataSource.postBookmarked().code
        }
    }

    override suspend fun deleteBookmarked(): Result<Int> {
        return runCatching {
            dataSource.deleteBookmarked().code
        }
    }

    override suspend fun getSpaceDetail(): Result<SpaceDetailData> {
        return runCatching {
            dataSource.getSpaceDetail().data
        }
    }

    override suspend fun getCuration(): Result<List<CurationData>> {
        return runCatching {
            dataSource.getCuration().data
        }
    }


    override suspend fun getFollow(): Result<FollowData> {
        return runCatching {
            dataSource.getFollow().data
        }
    }

    override suspend fun postFollow(): Result<Int> {
        return runCatching {
            dataSource.postFollow().code
        }
    }

    override suspend fun getSpaceArticle(): Result<SpaceArticleData?> {
        return runCatching {
            dataSource.getSpaceArticle().data
        }
    }
}