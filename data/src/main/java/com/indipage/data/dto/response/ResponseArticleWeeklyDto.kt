package com.indipage.data.dto.response

import com.indipage.domain.model.ArticleWeekly
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ResponseArticleWeeklyDto(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("spaceName") val spaceName: String,
    @SerialName("spaceOwner") val spaceOwner: String,
    @SerialName("remainingDays") val remainingDays: Int,
    @SerialName("thumbnailUrlOfThisWeek") val thumbnailUrlOfThisWeek: String,
    @SerialName("thumbnailUrlOfNextWeek") val thumbnailUrlOfNextWeek: String
) {
    fun toArticleWeeklyEntity() = ArticleWeekly(
        id,
        title,
        spaceName,
        spaceOwner,
        remainingDays,
        thumbnailUrlOfThisWeek,
        thumbnailUrlOfThisWeek
    )
}
