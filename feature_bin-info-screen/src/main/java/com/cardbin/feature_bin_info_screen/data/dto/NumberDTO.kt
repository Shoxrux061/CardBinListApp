package com.cardbin.feature_bin_info_screen.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NumberDTO(
    @field:Json(name = "length")
    val length: Int?,
    @field:Json(name = "luhn")
    val luhn: Boolean?
)