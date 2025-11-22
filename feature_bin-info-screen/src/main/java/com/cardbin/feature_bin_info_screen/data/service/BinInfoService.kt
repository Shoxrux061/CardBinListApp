package com.cardbin.feature_bin_info_screen.data.service

import com.cardbin.feature_bin_info_screen.data.dto.CardInfoResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BinInfoService {

    @GET("{bin}")
    suspend fun getBinInfo(
        @Path("bin")
        bin: String
    ): Response<CardInfoResponseDTO>

}