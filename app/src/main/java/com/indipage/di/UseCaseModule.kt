package com.indipage.di

import com.indipage.domain.repository.BookMarkRepository
import com.indipage.domain.repository.TicketRepository
import com.indipage.domain.repository.UserRepository
import com.indipage.domain.usecase.BookMarkUseCase
import com.indipage.domain.usecase.TicketUseCase
import com.indipage.domain.usecase.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideTicketUseCase(repository: TicketRepository): TicketUseCase {
        return TicketUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideBookmarkUseCase(repository: BookMarkRepository): BookMarkUseCase {
        return BookMarkUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideUserUseCase(repository: UserRepository): UserUseCase {
        return UserUseCase(repository)
    }

}