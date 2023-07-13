package com.indipage.di

import com.indipage.data.repositoryimpl.ArticleDetailRepositoryImpl
import com.indipage.data.repositoryimpl.BookMarkRepositoryImpl
import com.indipage.data.repositoryimpl.TestRepositoryImpl
import com.indipage.domain.repository.ArticleDetailRepository
import com.indipage.domain.repository.BookMarkRepository
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

    @Singleton
    @Binds
    abstract fun providesBookMarkRepository(repoImpl: BookMarkRepositoryImpl): BookMarkRepository

    @Singleton
    @Binds
    abstract fun providesArticleDetailRepository(repoImpl: ArticleDetailRepositoryImpl): ArticleDetailRepository
}