package com.indipage.domain.repository

import com.indipage.data.dto.response.ResponseArticleDetailDto

interface ArticleDetailRepository {
    suspend fun getArticleDetail(articleId: Long): Result<ResponseArticleDetailDto>
}