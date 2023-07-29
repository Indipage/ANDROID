package com.indipage.domain.model

data class SpaceDetail(
    val id: Int?,
    val name: String,
    val imageUrl: String?,
    val address: String?,
    val type: String,
    val owner: String?,
    val operatingTime: String?,
    val closed: String?,
    val introduction: String?,
    val peculiarityTitle: String?,
    val peculiarityContent: String?,
    val peculiarityImageUrl: String?,
    val tagList: List<Tag>
)

data class Tag(
    val id: Int?,
    val name: String?
)