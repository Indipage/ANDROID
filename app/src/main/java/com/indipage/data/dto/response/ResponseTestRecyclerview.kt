package com.indipage.data.dto.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseTestRecyclerview(
    @SerialName("testData")
    val testData: List<TestRecyclerviewImage>,
)