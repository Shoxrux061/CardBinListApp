package com.cardbin.feature_bin_info_screen.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryDTO(
    @field:Json(name = "alpha2")
    val alpha2: String?,
    @field:Json(name = "currency")
    val currency: String?,
    @field:Json(name = "emoji")
    val emoji: String?,
    @field:Json(name = "latitude")
    val latitude: Int?,
    @field:Json(name = "longitude")
    val longitude: Int?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "numeric")
    val numeric: String?
)