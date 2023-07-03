package com.indipage.di.extension

import com.indipage.data.repositoryimpl.TestRepositoryImpl
import com.indipage.domain.repository.TestApiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providesTestRecyclerviewRepo(repoImpl: TestRepositoryImpl): TestApiRepository

}