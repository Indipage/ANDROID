package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.response.ResponseArticleDto
import com.indipage.data.dto.response.ResponseSpaceDto
import com.indipage.data.dto.response.SavedSpace

interface BookMarkDataSource {
    suspend fun getSavedArticles(): BaseResponse<List<ResponseArticleDto>>
    suspend fun getSavedSpaces(): BaseResponseNullable<List<ResponseSpaceDto>>
}