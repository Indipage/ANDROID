package com.indipage.di

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
}