package com.indipage.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSearchData(
    @SerialName("SearchDetailData")
    val searchDetailData: List<SearchDetailData>,
    @SerialName("created_time")
    val time: String
) {
    @Serializable
    data class SearchDetailData(
        @SerialName("name")
        val name: String,
        @SerialName("id")
        val id: Int,
        @SerialName("address")
        val address: String,
        @SerialName("photo")
        val imageUrl: String?
    )
}