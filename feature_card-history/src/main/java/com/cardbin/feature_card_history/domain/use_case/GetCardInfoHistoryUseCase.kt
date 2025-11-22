package com.cardbin.feature_card_history.domain.use_case

import com.cardbin.feature_card_history.domain.models.CardInfoUi
import com.cardbin.feature_card_history.domain.repository.CardInfoHistoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCardInfoHistoryUseCase @Inject constructor(
    private val repository: CardInfoHistoryRepository
) {

    operator fun invoke(): Flow<List<CardInfoUi>> {
        return repository.getCardInfoHistory()
    }

}