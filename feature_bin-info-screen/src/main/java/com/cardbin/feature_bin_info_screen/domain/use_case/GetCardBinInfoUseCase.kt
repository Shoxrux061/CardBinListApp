package com.cardbin.feature_bin_info_screen.domain.use_case

import com.cardbin.feature_bin_info_screen.data.repository.CardBinInfoRepositoryInfo
import com.cardbin.feature_bin_info_screen.domain.models.CardInfoUi
import com.cardbin.shared_core.handler.NetworkResult
import javax.inject.Inject

class GetCardBinInfoUseCase @Inject constructor(
    private val repository: CardBinInfoRepositoryInfo
) {
    suspend operator fun invoke(bin: String): NetworkResult<CardInfoUi> {
        return repository.getCardInfo(bin)
    }
}