package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.SpaceDetailDataSource
import com.indipage.domain.entity.Curation
import com.indipage.domain.entity.SpaceArticle
import com.indipage.domain.entity.SpaceDetail
import com.indipage.domain.repository.SpaceDetailRepository
import javax.inject.Inject

class SpaceDetailRepositoryImpl @Inject constructor(
    private val dataSource: SpaceDetailDataSource
) : SpaceDetailRepository {

    override suspend fun getBookmarked(spaceId: Int): Result<Boolean> {
        return runCatching {
            dataSource.getBookmarked(spaceId).data.bookmarked
        }
    }

    override suspend fun postBookmarked(spaceId: Int): Result<Int> {
        return runCatching {
            dataSource.postBookmarked(spaceId).code
        }
    }

    override suspend fun deleteBookmarked(spaceId: Int): Result<Int> {
        return runCatching {
            dataSource.deleteBookmarked(spaceId).code
        }
    }

    override suspend fun getSpaceDetail(spaceId: Int): Result<SpaceDetail?> {
        return runCatching {
            dataSource.getSpaceDetail(spaceId).data?.toSpaceDetail()
        }
    }

    override suspend fun getCuration(spaceId: Int): Result<List<Curation>?> {
        return runCatching {
            dataSource.getCuration(spaceId).data?.map { curationData -> curationData.toCuration() }
        }
    }


    override suspend fun getFollow(spaceId: Int): Result<Boolean> {
        return runCatching {
            dataSource.getFollow(spaceId).data.isFollowed
        }
    }

    override suspend fun postFollow(spaceId: Int): Result<Int> {
        return runCatching {
            dataSource.postFollow(spaceId).code
        }
    }

    override suspend fun getSpaceArticle(spaceId: Int): Result<SpaceArticle?> {
        return runCatching {
            dataSource.getSpaceArticle(spaceId).data?.toSpaceArticle()
        }
    }
}