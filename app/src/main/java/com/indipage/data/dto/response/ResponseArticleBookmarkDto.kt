package com.indipage.data.dto.response

import com.indipage.domain.entity.ArticleBookmark
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseArticleBookmarkDto(
    @SerialName("bookmarked")
    val bookmarked: Boolean
) {
    fun toArticleBookmarkEntity() = ArticleBookmark(bookmarked)
}
