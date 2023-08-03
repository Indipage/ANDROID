package com.indipage.domain.usecase

import com.indipage.domain.model.Space
import com.indipage.domain.repository.BookMarkRepository
import kotlinx.coroutines.flow.Flow

class BookMarkSpaceUseCase(
    private val repository: BookMarkRepository
) {
    suspend operator fun invoke(): Flow<List<Space>?> =
        repository.getSavedSpaces()
}
