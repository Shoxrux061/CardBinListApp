package com.cardbin.shareed_data.local.room.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("cards")
data class CardInfoEntity(
    @PrimaryKey val bin: String,
    val brand: String?,
    val prepaid: Boolean?,
    val scheme: String?,
    val type: String?,
    val bankCity: String?,
    val bankName: String?,
    val bankPhone: String?,
    val bankUrl: String?,
    val numberLength: Int?,
    val numberLuhn: Boolean?,
    val countryAlpha2: String?,
    val countryCurrency: String?,
    val countryEmoji: String?,
    val countryLatitude: Int?,
    val countryLongitude: Int?,
    val countryName: String?,
    val countryNumeric: String?
)