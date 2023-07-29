package com.indipage.domain.model

data class ArticleAll(
    val spaceName: String,
    val title: String,
    val spaceType: String,
    val id: Int,
    val issueDate: String,
    val thumbnailUrl: String,
    val ticketReceived: Boolean
)