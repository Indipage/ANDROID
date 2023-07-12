package com.indipage.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ResponseSpaceDetailDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: SpaceDetailData?
) {
    @Serializable
    data class SpaceDetailData(
        @SerialName("id")
        val id: Int?,
        @SerialName("name")
        val name: String,
        @SerialName("imageUrl")
        val imageUrl: String?,
        @SerialName("roadAddress")
        val address: String,
        @SerialName("type")
        val type: String,
        @SerialName("owner")
        val owner: String?,
        @SerialName("operatingTime")
        val operatingTime: String?,
        @SerialName("closedDays")
        val closed: String?,
        @SerialName("introduction")
        val introduction: String?,
        @SerialName("peculiarityTitle")
        val peculiarityTitle: String?,
        @SerialName("peculiarityContent")
        val peculiarityContent: String?,
        @SerialName("peculiarityImageUrl")
        val peculiarityImageUrl: String?,
        @SerialName("tagList")
        val tagList: Array<SpaceTag>
    ) {
        @Serializable
        data class SpaceTag(
            @SerialName("id")
            val id: Int?,
            @SerialName("name")
            val name: String?
        )
    }
}

