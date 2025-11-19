package com.cardbin.feature_bin_info_screen.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BankDTO(
    @field:Json(name = "city")
    val city: String?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "phone")
    val phone: String?,
    @field:Json(name = "url")
    val url: String?
)