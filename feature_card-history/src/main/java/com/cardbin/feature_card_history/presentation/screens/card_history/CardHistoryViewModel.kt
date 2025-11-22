package com.cardbin.feature_card_history.presentation.screens.card_history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cardbin.feature_card_history.domain.use_case.GetCardInfoHistoryUseCase
import com.cardbin.feature_card_history.presentation.screens.card_history.state.CardHistoryScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardHistoryViewModel @Inject constructor(
    private val useCase: GetCardInfoHistoryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CardHistoryScreenState())
    val uiState: StateFlow<CardHistoryScreenState> = _uiState

    init {
        getCardInfoHistory()
    }

    private fun getCardInfoHistory() {

        viewModelScope.launch {

            _uiState.update {
                it.copy(isLoading = true)
            }

            try {

                useCase().collect { result ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = null,
                            historyList = result
                        )

                    }
                }

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.localizedMessage
                    )
                }
            }
        }
    }
}