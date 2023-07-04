package com.indipage.di

import android.util.Log
import com.indipage.di.extension.isJsonArray
import com.indipage.di.extension.isJsonObject
import com.indipage.util.API.API_TAG
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(tokenInterceptor())
            .build()

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor { message ->
            when {
                message.isJsonObject() ->
                    Log.d(API_TAG, JSONObject(message).toString(4))
                message.isJsonArray() ->
                    Log.d(API_TAG, JSONArray(message).toString(4))
                else -> {
                    Log.d(API_TAG, "CONNECTION INFO -> $message")
                }
            }
        }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Singleton
    @Provides
    @TestRetrofit
    fun provideTestRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl("http://52.78.152.187:8080")
        .client(okHttpClient)
        .build()

    private fun tokenInterceptor(): Interceptor {
        val requestInterceptor = Interceptor { chain ->
            val original = chain.request()
            val builder = original.newBuilder()
            builder.addHeader("Authorization", "헤더의 토큰 값")
            chain.proceed(builder.build())
        }
        return requestInterceptor
    }

}

