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

    override suspend fun getBookmarked(spaceId:Int): Result<BookmarkData> {
        return runCatching {
            dataSource.getBookmarked(spaceId).data
        }
    }

    override suspend fun postBookmarked(spaceId:Int): Result<Int> {
        return runCatching {
            dataSource.postBookmarked(spaceId).code
        }
    }

    override suspend fun deleteBookmarked(spaceId:Int): Result<Int> {
        return runCatching {
            dataSource.deleteBookmarked(spaceId).code
        }
    }

    override suspend fun getSpaceDetail(spaceId:Int): Result<SpaceDetailData> {
        return runCatching {
            dataSource.getSpaceDetail(spaceId).data
        }
    }

    override suspend fun getCuration(spaceId:Int): Result<List<CurationData>> {
        return runCatching {
            dataSource.getCuration(spaceId).data
        }
    }


    override suspend fun getFollow(spaceId:Int): Result<FollowData> {
        return runCatching {
            dataSource.getFollow(spaceId).data
        }
    }

    override suspend fun postFollow(spaceId:Int): Result<Int> {
        return runCatching {
            dataSource.postFollow(spaceId).code
        }
    }

    override suspend fun getSpaceArticle(spaceId:Int): Result<SpaceArticleData?> {
        return runCatching {
            dataSource.getSpaceArticle(spaceId).data
        }
    }
}