package com.cardbin.project.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cardbin.feature_bin_info_screen.presentation.screens.bin_info_screen.BinInfoScreen
import com.cardbin.feature_bin_info_screen.presentation.screens.bin_info_screen.BinInfoViewModel
import com.cardbin.feature_card_history.presentation.screens.card_history.CardHistoryScreen
import com.cardbin.feature_card_history.presentation.screens.card_history.CardHistoryViewModel
import com.cardbin.shared_core.utils.NavigationRoutes

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = NavigationRoutes.CARD_INFO_SCREEN
    ) {
        composable(NavigationRoutes.CARD_INFO_SCREEN) {
            val viewModel = hiltViewModel<BinInfoViewModel>()
            BinInfoScreen(viewModel, navController)
        }

        composable(NavigationRoutes.CARD_HISTORY_SCREEN) {
            val viewModel = hiltViewModel<CardHistoryViewModel>()
            CardHistoryScreen(viewModel)
        }
    }
}