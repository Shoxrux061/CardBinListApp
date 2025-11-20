package com.cardbin.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.cardbin.feature_bin_info_screen.presentation.screens.bin_info_screen.BinInfoScreen
import com.cardbin.feature_bin_info_screen.presentation.screens.bin_info_screen.BinInfoViewModel
import com.cardbin.shared_core.ui.theme.CardBinListAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            CardBinListAppTheme {

                val viewModel = hiltViewModel<BinInfoViewModel>()

                BinInfoScreen(viewModel)
            }
        }
    }
}