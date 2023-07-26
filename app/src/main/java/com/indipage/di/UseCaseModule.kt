package com.indipage.di

import com.indipage.domain.repository.TicketRepository
import com.indipage.domain.usecase.TicketUseCase
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
    fun provideLoginUseCase(repository: TicketRepository): TicketUseCase{
        return TicketUseCase(repository)
    }

}