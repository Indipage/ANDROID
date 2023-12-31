package com.indipage.di


import com.indipage.data.repositoryimpl.*
import com.indipage.domain.repository.*
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
    abstract fun providesBookMarkRepository(repoImpl: BookMarkRepositoryImpl): BookMarkRepository

    @Singleton
    @Binds
    abstract fun providesSpaceDetailRepository(repoImpl: SpaceDetailRepositoryImpl): SpaceDetailRepository

    @Singleton
    @Binds
    abstract fun provideUserRepository(repoImpl: UserRepositoryImpl): UserRepository

    @Singleton
    @Binds
    abstract fun provideTicketRepository(repoImpl: TicketRepositoryImpl): TicketRepository

    @Singleton
    @Binds
    abstract fun providesArticleDetailRepository(repoImpl: ArticleDetailRepositoryImpl): ArticleDetailRepository

    @Singleton
    @Binds
    abstract fun providesArticleRepository(repoImpl: ArticleRepositoryImpl): ArticleRepository

    @Singleton
    @Binds
    abstract fun providesSearchRepository(repoImpl: SearchRepositoryImpl): SearchRepository

    @Singleton
    @Binds
    abstract fun providesSignInRepository(repoImpl: SignInRepositoryImpl): SignInRepository

    @Singleton
    @Binds
    abstract fun providesAuthRepository(repoImpl: AuthRepositoryImpl): AuthRepository
}