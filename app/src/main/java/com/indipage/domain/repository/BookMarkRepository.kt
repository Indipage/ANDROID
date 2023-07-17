package com.indipage.domain.repository

import com.indipage.data.dto.response.ResponseArticleDto
import com.indipage.data.dto.response.ResponseSpaceDto

interface BookMarkRepository {
    suspend fun getSavedArticles(): Result<List<ResponseArticleDto>>
    suspend fun getSavedSpaces(): Result<List<ResponseSpaceDto>>

}