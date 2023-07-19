package com.indipage.di

import com.indipage.data.api.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideBookMarkService(@IndiPageRetrofit retrofit: Retrofit): BookMarkApiService =
        retrofit.create(BookMarkApiService::class.java)

    @Provides
    @Singleton
    fun provideSpaceDetailService(@IndiPageRetrofit retrofit: Retrofit): SpaceDetailApiService =
        retrofit.create(SpaceDetailApiService::class.java)

    @Provides
    @Singleton
    fun provideUserService(@IndiPageRetrofit retrofit: Retrofit): UserApiService =
        retrofit.create(UserApiService::class.java)

    @Provides
    @Singleton
    fun articleDetailApiService(@IndiPageRetrofit retrofit: Retrofit): ArticleDetailApiService =
        retrofit.create(ArticleDetailApiService::class.java)

    @Provides
    @Singleton
    fun provideTicketService(@IndiPageRetrofit retrofit: Retrofit): TicketApiService =
        retrofit.create(TicketApiService::class.java)

    @Provides
    @Singleton
    fun provideArticleService(@IndiPageRetrofit retrofit: Retrofit): ArticleApiService =
        retrofit.create(ArticleApiService::class.java)

    @Provides
    @Singleton
    fun provideSearchService(@IndiPageRetrofit retrofit: Retrofit): SearchApiService =
        retrofit.create(SearchApiService::class.java)

}