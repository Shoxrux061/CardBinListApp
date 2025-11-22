package com.cardbin.feature_card_history.domain.models

data class CardInfoUi(
    val bin: String,
    val bank: BankUi?,
    val brand: String?,
    val country: CountryUi?,
    val number: NumberUi?,
    val prepaid: Boolean?,
    val scheme: String?,
    val type: String?
)