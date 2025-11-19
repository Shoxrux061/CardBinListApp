package com.cardbin.feature_bin_info_screen.domain.repository

interface CardInfoRepository {

    suspend fun getCardInfo(bin: String)

}