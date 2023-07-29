package com.indipage.data.dto.response

import com.indipage.domain.model.ArticleAll
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseArticleAllDto(
    @SerialName("spaceName")
    val spaceName: String,
    @SerialName("title")
    val title: String,
    @SerialName("spaceType")
    val spaceType: String,
    @SerialName("id")
    val id: Int,
    @SerialName("issueDate")
    val issueDate: String,
    @SerialName("thumbnailUrl")
    val thumbnailUrl: String,
    @SerialName("ticketReceived")
    val ticketReceived: Boolean
) {
    fun toArticleAllEntity() =
        ArticleAll(spaceName, title, spaceType, id, issueDate, thumbnailUrl, ticketReceived)
}