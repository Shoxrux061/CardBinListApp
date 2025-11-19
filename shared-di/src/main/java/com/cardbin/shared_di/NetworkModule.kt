package com.cardbin.shared_di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @[Provides Singleton]
    fun provideRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://lookup.binlist.net/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @[Provides Singleton]
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .build()
    }

    @[Provides Singleton]
    fun provideOkHttp(chuckerInterceptor: ChuckerInterceptor): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(chuckerInterceptor)
            .build()
    }

    @[Provides Singleton]
    fun provideChuckerInterceptor(
        collector: ChuckerCollector,
        @ApplicationContext context: Context
    ): ChuckerInterceptor {

        return ChuckerInterceptor.Builder(context)
            .collector(collector)
            .maxContentLength(250_000L)
            .redactHeaders("Auth-Token", "Bearer")
            .alwaysReadResponseBody(true)
            .build()
    }

    @[Provides Singleton]
    fun provideChuckerCollector(@ApplicationContext context: Context): ChuckerCollector {
        return ChuckerCollector(
            context = context,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )
    }

}