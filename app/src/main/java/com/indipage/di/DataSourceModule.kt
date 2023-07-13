package com.indipage.di

import com.indipage.data.datasource.BookMarkDataSource
import com.indipage.data.datasource.SpaceDetailDataSource
import com.indipage.data.datasource.TestDataSource
import com.indipage.data.datasource.TicketDataSource
import com.indipage.data.datasource.UserDataSource
import com.indipage.data.datasource.remote.BookMarkDataSourceImpl
import com.indipage.data.datasource.remote.SpaceDetailDataSourceImpl
import com.indipage.data.datasource.remote.TestDataSourceImpl
import com.indipage.data.datasource.remote.TicketDataSourceImpl
import com.indipage.data.datasource.remote.UserDataSourceImpl
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
    abstract fun providesSpaceDetailDataSource(DataSourceImpl: SpaceDetailDataSourceImpl): SpaceDetailDataSource

    @Singleton
    @Binds
    abstract fun providesUserDataSource(DataSourceImpl: UserDataSourceImpl): UserDataSource

    @Singleton
    @Binds
    abstract fun providesTicketDataSource(DataSourceImpl: TicketDataSourceImpl): TicketDataSource

}