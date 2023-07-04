package com.indipage.di

import com.indipage.data.datasource.Remote.TestDataSourceImpl
import com.indipage.data.datasource.TestDataSource
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
    abstract fun providesTestRecyclerviewRepo(TestDataSourceImpl: TestDataSourceImpl): TestDataSource

}