package com.indipage.domain.repository

import com.indipage.domain.entity.Article
import com.indipage.domain.entity.Space

interface BookMarkRepository {
    suspend fun getSavedArticles(): Result<List<Article>?>
    suspend fun getSavedSpaces(): Result<List<Space>?>

}