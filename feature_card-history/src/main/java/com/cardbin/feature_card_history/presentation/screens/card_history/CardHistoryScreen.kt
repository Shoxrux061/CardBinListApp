package com.cardbin.feature_card_history.presentation.screens.card_history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
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
        isLoading -> LoadingScreen()
        error != null -> ErrorScreen(error) {}
        historyList.isEmpty() -> EmptyHistoryPlaceholder(modifier = Modifier.fillMaxSize())
        else -> CardHistoryContent(historyList)
    }


}

@Composable
fun EmptyHistoryPlaceholder(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "History is empty",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.secondary
        )
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