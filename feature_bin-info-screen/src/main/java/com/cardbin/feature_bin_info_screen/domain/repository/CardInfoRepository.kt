package com.cardbin.feature_bin_info_screen.domain.repository

import com.cardbin.feature_bin_info_screen.domain.models.CardInfoUi
import com.cardbin.shared_core.handler.NetworkResult

interface CardInfoRepository {

    suspend fun getCardInfo(bin: String): NetworkResult<CardInfoUi>

}