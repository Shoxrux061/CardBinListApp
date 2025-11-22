package com.cardbin.feature_card_history.presentation.screens.card_history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.cardbin.feature_card_history.data.mapper.toMap
import com.cardbin.feature_card_history.domain.models.CardInfoUi
import com.cardbin.shared_core.ui.components.ErrorScreen
import com.cardbin.shared_core.ui.components.LoadingScreen

@Composable
fun CardHistoryScreen(viewModel: CardHistoryViewModel) {

    val uiState = viewModel.uiState.collectAsState()
    val isLoading = uiState.value.isLoading
    val error = uiState.value.error
    val historyList = uiState.value.historyList

    when {

        isLoading -> {
            LoadingScreen()
        }

        error != null -> {
            ErrorScreen(error) { }
        }

        historyList.isNotEmpty() -> {
            CardHistoryContent(historyList)
        }

    }


}

@Composable
fun CardHistoryContent(historyList: List<CardInfoUi>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(historyList.size) {
            CardInfoContainer(historyList[it].toMap())
        }
    }

}