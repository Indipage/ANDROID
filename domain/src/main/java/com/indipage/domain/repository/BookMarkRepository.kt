package com.indipage.domain.repository

import com.indipage.domain.model.Article
import com.indipage.domain.model.Space

interface BookMarkRepository {
    suspend fun getSavedArticles(): Result<List<Article>?>
    suspend fun getSavedSpaces(): Result<List<Space>?>

}