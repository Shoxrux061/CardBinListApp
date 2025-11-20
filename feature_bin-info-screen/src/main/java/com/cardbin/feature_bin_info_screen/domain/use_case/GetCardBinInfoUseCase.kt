package com.cardbin.feature_bin_info_screen.domain.use_case

import com.cardbin.feature_bin_info_screen.domain.models.CardInfoUi
import com.cardbin.feature_bin_info_screen.domain.repository.CardInfoRepository
import com.cardbin.shared_core.handler.NetworkResult
import javax.inject.Inject

class GetCardBinInfoUseCase @Inject constructor(
    private val repository: CardInfoRepository
) {
    suspend operator fun invoke(bin: String): NetworkResult<CardInfoUi> {
        return repository.getCardInfo(bin)
    }
}