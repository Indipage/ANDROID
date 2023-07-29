package com.indipage.data.dto.response

import com.indipage.domain.entity.ArticleDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseArticleDetailDto(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("content") val content: String,
    @SerialName("issueDate") val issueDate: String,
    @SerialName("thumbnailUrl") val thumbnailUrl: String,
    @SerialName("spaceId") val spaceId: Int,
    @SerialName("spaceName") val spaceName: String,
    @SerialName("spaceOwner") val spaceOwner: String
) {
    fun toArticleDetailEntity() =
        ArticleDetail(id, title, content, issueDate, thumbnailUrl, spaceId, spaceName, spaceOwner)
}