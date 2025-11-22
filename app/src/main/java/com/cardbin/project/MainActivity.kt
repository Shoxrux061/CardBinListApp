package com.cardbin.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.cardbin.feature_card_history.presentation.screens.card_history.CardHistoryScreen
import com.cardbin.feature_card_history.presentation.screens.card_history.CardHistoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            val viewModel = hiltViewModel<CardHistoryViewModel>()

            LaunchedEffect(Unit) {
                viewModel.getCardInfoHistory()
            }

            CardHistoryScreen(viewModel)
        }
    }
}