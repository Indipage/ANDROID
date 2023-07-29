package com.indipage.domain.model

data class Curation(
    val bookData: Book,
    val comment: String
)

data class Book(
    val id: Int,
    val title: String,
    val imageUrl: String
)