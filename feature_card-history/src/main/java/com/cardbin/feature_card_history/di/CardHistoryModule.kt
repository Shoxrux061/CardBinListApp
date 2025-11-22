package com.cardbin.feature_card_history.di

import com.cardbin.feature_card_history.data.local.room.CardInfoDao
import com.cardbin.feature_card_history.data.repository.CardInfoHistoryRepositoryImpl
import com.cardbin.feature_card_history.domain.repository.CardInfoHistoryRepository
import com.cardbin.feature_card_history.domain.use_case.GetCardInfoHistoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CardHistoryModule {

    @Provides
    @Singleton
    fun provideCardHistoryRepository(
        dao: CardInfoDao
    ): CardInfoHistoryRepository {
        return CardInfoHistoryRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideCardHistoryUseCase(repository: CardInfoHistoryRepository): GetCardInfoHistoryUseCase {
        return GetCardInfoHistoryUseCase(repository)
    }
}