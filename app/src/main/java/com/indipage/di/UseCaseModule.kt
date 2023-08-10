package com.indipage.di

import com.indipage.domain.repository.*
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
    fun provideArticleUseCase(repository: ArticleRepository): ArticleUseCase {
        return ArticleUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideArticleDetailUseCase(repository: ArticleDetailRepository): ArticleDetailUseCase {
        return ArticleDetailUseCase(repository)
    }

}