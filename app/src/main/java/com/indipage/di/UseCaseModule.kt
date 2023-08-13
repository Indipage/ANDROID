package com.indipage.di

import com.indipage.domain.repository.BookMarkRepository
import com.indipage.domain.repository.SearchRepository
import com.indipage.domain.repository.SpaceDetailRepository
import com.indipage.domain.repository.TicketRepository
import com.indipage.domain.repository.UserRepository
import com.indipage.domain.usecase.*
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
    fun provideCardUseCase(repository: TicketRepository): CardUseCase {
        return CardUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideBookmarkArticleUseCase(repository: BookMarkRepository): BookMarkArticleUseCase {
        return BookMarkArticleUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideBookmarkSpaceUseCase(repository: BookMarkRepository): BookMarkSpaceUseCase {
        return BookMarkSpaceUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideUserUseCase(repository: UserRepository): UserUseCase {
        return UserUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideSpaceDetailUseCase(repository: SpaceDetailRepository): SpaceDetailUseCase {
        return SpaceDetailUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideSearchUseCase(repository: SearchRepository): SearchUseCase {
        return provideSearchUseCase(repository)
    }
}