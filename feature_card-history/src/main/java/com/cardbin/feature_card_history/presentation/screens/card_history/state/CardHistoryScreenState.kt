package com.cardbin.feature_card_history.presentation.screens.card_history.state

import com.cardbin.feature_card_history.domain.models.CardInfoUi

data class CardHistoryScreenState(

    val isLoading: Boolean = false,
    val historyList: List<CardInfoUi> = emptyList(),
    val error: String? = null

)