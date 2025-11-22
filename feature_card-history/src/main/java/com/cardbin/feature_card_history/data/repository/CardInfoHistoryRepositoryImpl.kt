package com.cardbin.feature_card_history.data.repository

import com.cardbin.feature_card_history.data.mapper.toDomain
import com.cardbin.feature_card_history.domain.models.CardInfoUi
import com.cardbin.feature_card_history.domain.repository.CardInfoHistoryRepository
import com.cardbin.shareed_data.local.room.local.room.CardInfoDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CardInfoHistoryRepositoryImpl @Inject constructor(
    private val room: CardInfoDao
) : CardInfoHistoryRepository {

    override fun getCardInfoHistory(): Flow<List<CardInfoUi>> {
        return room.getCardInfoList()
            .map { list -> list.map { it.toDomain() } }
    }

}