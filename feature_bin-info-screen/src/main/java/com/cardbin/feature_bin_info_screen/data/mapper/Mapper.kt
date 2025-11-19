package com.cardbin.feature_bin_info_screen.data.mapper

import com.cardbin.feature_bin_info_screen.data.dto.BankDTO
import com.cardbin.feature_bin_info_screen.data.dto.CardInfoResponseDTO
import com.cardbin.feature_bin_info_screen.data.dto.CountryDTO
import com.cardbin.feature_bin_info_screen.data.dto.NumberDTO
import com.cardbin.feature_bin_info_screen.domain.models.BankUi
import com.cardbin.feature_bin_info_screen.domain.models.CardInfoUi
import com.cardbin.feature_bin_info_screen.domain.models.CountryUi
import com.cardbin.feature_bin_info_screen.domain.models.NumberUi

fun BankDTO.toDomain(): BankUi {
    return BankUi(
        city = city,
        name = name,
        phone = phone,
        url = url
    )
}

fun CountryDTO.toDomain(): CountryUi {
    return CountryUi(
        alpha2 = alpha2,
        currency = currency,
        emoji = emoji,
        latitude = latitude,
        longitude = longitude,
        name = name,
        numeric = numeric
    )
}

fun NumberDTO.toDomain(): NumberUi {
    return NumberUi(
        length = length,
        luhn = luhn
    )
}

fun CardInfoResponseDTO.toDomain(): CardInfoUi {

    return CardInfoUi(
        bank = bank?.toDomain(),
        brand = brand,
        country = country?.toDomain(),
        number = number?.toDomain(),
        prepaid = prepaid,
        scheme = scheme,
        type = type
    )

}