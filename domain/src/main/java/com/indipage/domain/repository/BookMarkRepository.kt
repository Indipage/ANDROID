package com.indipage.domain.repository

import com.indipage.domain.Outcome
import com.indipage.domain.model.Article
import com.indipage.domain.model.Space
import kotlinx.coroutines.flow.Flow

interface BookMarkRepository {
    suspend fun getSavedArticles(): Flow<Outcome<List<Article>?>>
    suspend fun getSavedSpaces(): Flow<List<Space>?>

}