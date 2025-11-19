package com.cardbin.feature_bin_info_screen.data.repository

import com.cardbin.feature_bin_info_screen.data.mapper.toDomain
import com.cardbin.feature_bin_info_screen.data.service.BinInfoService
import com.cardbin.feature_bin_info_screen.domain.repository.CardInfoRepository
import com.cardbin.shared_core.handler.safeApiCall
import javax.inject.Inject

class CardBinInfoRepositoryInfo @Inject constructor(
    private val service: BinInfoService
) : CardInfoRepository {

    override suspend fun getCardInfo(bin: String) {

        safeApiCall(
            apiCall = {
                service.getBinInfo(bin)
            },
            mapper = { dto ->
                dto.toDomain()
            }
        )
    }
}