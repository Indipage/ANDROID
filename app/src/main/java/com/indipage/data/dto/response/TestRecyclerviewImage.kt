package com.indipage.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class TestRecyclerviewImage(

    @SerialName("id")
    val id: Long,
    @SerialName("image_url")
    val imageUrl: String
)