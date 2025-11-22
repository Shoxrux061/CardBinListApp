package com.cardbin.feature_bin_info_screen.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CardInfoResponseDTO(
    @field:Json(name = "bank")
    val bank: BankDTO?,
    @field:Json(name = "brand")
    val brand: String?,
    @field:Json(name = "country")
    val country: CountryDTO?,
    @field:Json(name = "number")
    val number: NumberDTO?,
    @field:Json(name = "prepaid")
    val prepaid: Boolean?,
    @field:Json(name = "scheme")
    val scheme: String?,
    @field:Json(name = "type")
    val type: String?
)