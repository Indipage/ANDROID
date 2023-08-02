package com.indipage.model

data class ArticleModel(
    val spaceName: String,
    val title: String,
    val spaceType: String,
    val id: Int,
    val issueDate: String,
    val thumbnailUrl: String,
    val ticketReceived: Boolean,
)
