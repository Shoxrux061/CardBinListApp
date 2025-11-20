package com.cardbin.feature_bin_info_screen.presentation.screens.bin_info_screen

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cardbin.feature_bin_info_screen.domain.use_case.GetCardBinInfoUseCase
import com.cardbin.feature_bin_info_screen.presentation.screens.bin_info_screen.state.BinInfoScreenUiState
import com.cardbin.shared_core.handler.onResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinInfoViewModel @Inject constructor(
    private val useCase: GetCardBinInfoUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(BinInfoScreenUiState())
    val uiState: StateFlow<BinInfoScreenUiState> = _uiState

    fun getCardBinInfo(bin: String) {

        _uiState.update {
            it.copy(isLoading = true)
        }

        viewModelScope.launch {
            try {
                useCase.invoke(bin).onResult(
                    onSuccess = { result ->
                        _uiState.update { currentState ->
                            currentState.copy(
                                cardInfo = result,
                                isLoading = false,
                                error = null
                            )
                        }
                    },
                    onError = { error ->
                        _uiState.update { currentState ->
                            currentState.copy(
                                isLoading = false,
                                error = error.toString()
                            )
                        }
                    }
                )

            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        error = e.toString()
                    )
                }
            }
        }
    }

    fun changeTextFieldValue(newText: String) {

        val digits = newText.filter { it.isDigit() }.take(8)
        val formatted = digits.chunked(4).joinToString(" ")

        _uiState.update {
            it.copy(
                textValue = TextFieldValue(
                    text = formatted,
                    selection = TextRange(formatted.length)
                )
            )
        }
    }

}