package com.indipage.di

import com.indipage.data.datasource.ArticleDetailDataSource
import com.indipage.data.datasource.BookMarkDataSource
import com.indipage.data.datasource.TestDataSource
import com.indipage.data.datasource.remote.ArticleDetailDataSourceImpl
import com.indipage.data.datasource.remote.BookMarkDataSourceImpl
import com.indipage.data.datasource.remote.TestDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun providesTestDataSource(TestDataSourceImpl: TestDataSourceImpl): TestDataSource

    @Singleton
    @Binds
    abstract fun providesBookMarkDataSource(DataSourceImpl: BookMarkDataSourceImpl): BookMarkDataSource

    @Singleton
    @Binds
    abstract fun providesArticleDetailDataSource(DataSourceImpl: ArticleDetailDataSourceImpl): ArticleDetailDataSource

}