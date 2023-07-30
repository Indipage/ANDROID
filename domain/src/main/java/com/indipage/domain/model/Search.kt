package com.indipage.domain.model

data class Search(
    val spaceId: Int,
    val spaceName: String,
    val address: String,
    val imageUrl: String?
)