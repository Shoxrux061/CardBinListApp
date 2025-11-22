package com.cardbin.feature_card_history.domain.repository

import com.cardbin.feature_card_history.domain.models.CardInfoUi
import kotlinx.coroutines.flow.Flow

interface CardInfoHistoryRepository {

    fun getCardInfoHistory(): Flow<List<CardInfoUi>>

}