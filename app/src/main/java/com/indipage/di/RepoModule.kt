package com.indipage.di

import com.indipage.data.repositoryimpl.BookMarkRepositoryImpl
import com.indipage.data.repositoryimpl.TestRepositoryImpl
import com.indipage.data.repositoryimpl.TicketRepositoryImpl
import com.indipage.data.repositoryimpl.UserRepositoryImpl
import com.indipage.domain.repository.BookMarkRepository
import com.indipage.domain.repository.TestApiRepository
import com.indipage.domain.repository.TicketRepository
import com.indipage.domain.repository.UserRepository
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

    @Singleton
    @Binds
    abstract fun providesBookMarkRepository(repoImpl: BookMarkRepositoryImpl): BookMarkRepository

    @Singleton
    @Binds
    abstract fun provideUserRepository(repoImpl: UserRepositoryImpl): UserRepository

    @Singleton
    @Binds
    abstract fun provideTicketRepository(repoImpl: TicketRepositoryImpl): TicketRepository
}