package com.indipage.domain.model

data class ArticleWeekly(
    val id: Int,
    val title: String,
    val spaceName: String,
    val spaceOwner: String? = null,
    val remainingDays: Int,
    val thumbnailUrlOfThisWeek: String,
    val thumbnailUrlOfNextWeek: String
)