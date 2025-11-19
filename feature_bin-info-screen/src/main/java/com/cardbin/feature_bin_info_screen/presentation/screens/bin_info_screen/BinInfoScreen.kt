package com.cardbin.feature_bin_info_screen.presentation.screens.bin_info_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun BinInfoScreen(viewModel: BinInfoViewModel) {

    val uiState = viewModel.uiState.collectAsState()

    val cardInfo = uiState.value.cardInfo
    val isLoading = uiState.value.isLoading
    val error = uiState.value.error

    when {

        isLoading -> {

        }

    }


}