package com.cardbin.feature_bin_info_screen.data.repository

import com.cardbin.feature_bin_info_screen.data.mapper.toDomain
import com.cardbin.feature_bin_info_screen.data.mapper.toEntity
import com.cardbin.feature_bin_info_screen.data.service.BinInfoService
import com.cardbin.feature_bin_info_screen.domain.models.CardInfoUi
import com.cardbin.feature_bin_info_screen.domain.repository.CardInfoRepository
import com.cardbin.shared_core.handler.NetworkResult
import com.cardbin.shared_core.handler.safeApiCall
import com.cardbin.shareed_data.local.room.local.room.CardInfoDao
import javax.inject.Inject

class CardBinInfoRepositoryImpl @Inject constructor(
    private val service: BinInfoService,
    private val dao: CardInfoDao
) : CardInfoRepository {

    override suspend fun getCardInfo(bin: String): NetworkResult<CardInfoUi> {
        val result = safeApiCall(
            apiCall = { service.getBinInfo(bin) },
            mapper = { dto -> dto.toDomain(bin) }
        )

        if (result is NetworkResult.Success && result.data.scheme != null) {
            dao.insert(result.data.toEntity())
        }

        return result
    }

}