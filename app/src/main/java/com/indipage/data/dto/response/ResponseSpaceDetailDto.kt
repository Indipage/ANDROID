package com.indipage.data.dto.response

import com.indipage.domain.entity.SpaceDetail
import com.indipage.domain.entity.Tag
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class SpaceDetailData(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String,
    @SerialName("imageUrl")
    val imageUrl: String?,
    @SerialName("roadAddress")
    val address: String?,
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
    val tagList: List<SpaceTag>
) {
    @Serializable
    data class SpaceTag(
        @SerialName("id")
        val id: Int?,
        @SerialName("name")
        val name: String?
    ) {

        fun toTagList() = run {
            Tag(id, name)
        }
    }

    fun toSpaceDetail() = run {
        SpaceDetail(
            id,
            name,
            imageUrl,
            address,
            type,
            owner,
            operatingTime,
            closed,
            introduction,
            peculiarityTitle,
            peculiarityContent,
            peculiarityImageUrl,
            tagList.map { it.toTagList() }
        )
    }
}