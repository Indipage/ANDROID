package com.indipage.data.dto.kakao

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class KaKaoImage(
    @SerialName("collection")
    val collection: String,
    @SerialName("datetime")
    val datetime: String,
    @SerialName("display_sitename")
    val displaySitename: String,
    @SerialName("doc_url")
    val docUrl: String,
    @SerialName("height")
    val height: Int,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    @SerialName("width")
    val width: Int
)