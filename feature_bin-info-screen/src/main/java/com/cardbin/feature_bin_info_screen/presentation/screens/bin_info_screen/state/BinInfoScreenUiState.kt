package com.cardbin.feature_bin_info_screen.presentation.screens.bin_info_screen.state

import com.cardbin.feature_bin_info_screen.domain.models.CardInfoUi

data class BinInfoScreenUiState(

    val isLoading: Boolean = false,
    val cardInfo: CardInfoUi? = null,
    val error: String? = null

)