package com.indipage.domain.entity

data class ArticleDetail(
    val id: Int,
    val title: String,
    val content: String,
    val issueDate: String,
    val thumbnailUrl: String,
    val spaceId: Int,
    val spaceName: String,
    val spaceOwner: String
)