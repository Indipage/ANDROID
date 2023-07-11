package com.indipage.data.dto.response

data class MockCurationData(
    val comment: String,
    val bookData: MockBookData
)

data class MockBookData(
    val id: Int,
    val title: String,
    val imageUrl: String
)