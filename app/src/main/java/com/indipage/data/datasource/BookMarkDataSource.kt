package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.response.ResponseArticleDto
import com.indipage.data.dto.response.ResponseSpaceDto

interface BookMarkDataSource {
    suspend fun getSavedArticles(): BaseResponseNullable<List<ResponseArticleDto>>
    suspend fun getSavedSpaces(): BaseResponseNullable<List<ResponseSpaceDto>>
}