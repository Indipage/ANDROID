package com.indipage.di

import com.indipage.data.api.BookMarkApiService
import com.indipage.data.api.SpaceDetailApiService
import com.indipage.data.api.TestApiService
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
    fun provideTestService(@TestRetrofit retrofit: Retrofit): TestApiService =
        retrofit.create(TestApiService::class.java)

    @Provides
    @Singleton
    fun provideBookMarkService(@TestRetrofit retrofit: Retrofit): BookMarkApiService =
        retrofit.create(BookMarkApiService::class.java)


    @Provides
    @Singleton
    fun provideSpaceDetailService(@TestRetrofit retrofit: Retrofit): SpaceDetailApiService =
        retrofit.create(SpaceDetailApiService::class.java)
}