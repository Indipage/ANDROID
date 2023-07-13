package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.ResponseArticleDetailDto

interface ArticleDetailDataSource {
    suspend fun getArticleDetail(articleId: Long): BaseResponse<ResponseArticleDetailDto>
}