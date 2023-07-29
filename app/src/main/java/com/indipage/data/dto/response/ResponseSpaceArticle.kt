package com.indipage.data.dto.response

import com.indipage.domain.entity.SpaceArticle
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpaceArticleData(
    @SerialName("spaceName")
    val spaceName: String,
    @SerialName("title")
    val title: String,
    @SerialName("spaceType")
    val spaceType: String,
    @SerialName("id")
    val id: Int,
    @SerialName("imageUrl")
    val imageUrl: String
) {
    fun toSpaceArticle() = run {
        SpaceArticle(spaceName, title, spaceType, id, imageUrl)
    }
}