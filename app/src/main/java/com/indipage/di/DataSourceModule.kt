package com.indipage.di

import com.indipage.data.datasource.*
import com.indipage.data.datasource.remote.*

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
    abstract fun providesBookMarkDataSource(DataSourceImpl: BookMarkDataSourceImpl): BookMarkDataSource

    @Singleton
    @Binds
    abstract fun providesSpaceDetailDataSource(DataSourceImpl: SpaceDetailDataSourceImpl): SpaceDetailDataSource

    @Singleton
    @Binds
    abstract fun providesUserDataSource(DataSourceImpl: UserDataSourceImpl): UserDataSource

    @Singleton
    @Binds
    abstract fun providesTicketDataSource(DataSourceImpl: TicketDataSourceImpl): TicketDataSource

    @Singleton
    @Binds
    abstract fun providesArticleDetailDataSource(DataSourceImpl: ArticleDetailDataSourceImpl): ArticleDetailDataSource

    @Singleton
    @Binds
    abstract fun providesArticleDataSource(DataSourceImpl: ArticleDataSourceImpl): ArticleDataSource


}