package com.indipage.di.extension

import com.indipage.data.api.TestApi
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
    fun provideHomeApiService(@TestRetrofit retrofit: Retrofit): TestApi =
        retrofit.create(TestApi::class.java)
}