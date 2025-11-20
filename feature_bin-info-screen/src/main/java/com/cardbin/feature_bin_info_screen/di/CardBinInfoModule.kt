package com.cardbin.feature_bin_info_screen.di

import com.cardbin.feature_bin_info_screen.data.repository.CardBinInfoRepositoryImpl
import com.cardbin.feature_bin_info_screen.data.service.BinInfoService
import com.cardbin.feature_bin_info_screen.domain.repository.CardInfoRepository
import com.cardbin.feature_bin_info_screen.domain.use_case.GetCardBinInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CardBinInfoModule {

    @Provides
    @Singleton
    fun provideCardInfoService(retrofit: Retrofit): BinInfoService {
        return retrofit.create(BinInfoService::class.java)
    }

    @Provides
    @Singleton
    fun provideCardInfoRepository(service: BinInfoService): CardInfoRepository {
        return CardBinInfoRepositoryImpl(service)
    }

    @Provides
    @Singleton
    fun provideCardInfoUseCase(repository: CardInfoRepository): GetCardBinInfoUseCase {
        return GetCardBinInfoUseCase(repository)
    }

}