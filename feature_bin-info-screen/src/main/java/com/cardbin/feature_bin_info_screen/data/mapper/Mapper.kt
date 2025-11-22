package com.cardbin.feature_bin_info_screen.data.mapper

import com.cardbin.feature_bin_info_screen.data.dto.BankDTO
import com.cardbin.feature_bin_info_screen.data.dto.CardInfoResponseDTO
import com.cardbin.feature_bin_info_screen.data.dto.CountryDTO
import com.cardbin.feature_bin_info_screen.data.dto.NumberDTO
import com.cardbin.feature_bin_info_screen.domain.models.BankUi
import com.cardbin.feature_bin_info_screen.domain.models.CardInfoUi
import com.cardbin.feature_bin_info_screen.domain.models.CountryUi
import com.cardbin.feature_bin_info_screen.domain.models.NumberUi
import com.cardbin.shareed_data.local.room.local.room.CardInfoEntity

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

fun CardInfoResponseDTO.toDomain(bin: String): CardInfoUi {

    return CardInfoUi(
        bank = bank?.toDomain(),
        brand = brand,
        country = country?.toDomain(),
        number = number?.toDomain(),
        prepaid = prepaid,
        scheme = scheme,
        type = type,
        bin = bin
    )

}

fun CardInfoUi.toMap(): Map<String, String> {
    val map = mutableMapOf<String, String>()

    brand?.let { map["brand"] = it }
    scheme?.let { map["scheme"] = it }
    type?.let { map["type"] = it }
    prepaid?.let { map["prepaid"] = it.toString() }

    bank?.let { b ->
        b.name?.let { map["bank name"] = it }
        b.city?.let { map["bank city"] = it }
        b.phone?.let { map["bank phone"] = it }
        b.url?.let { map["bank url"] = it }
    }

    country?.let { c ->
        c.name?.let { map["country"] = it }
        c.alpha2?.let { map["country alpha2"] = it }
        c.currency?.let { map["country currency"] = it }
        c.emoji?.let { map["country emoji"] = it }
        c.latitude?.let { map["country latitude"] = it.toString() }
        c.longitude?.let { map["country longitude"] = it.toString() }
        c.numeric?.let { map["country numeric"] = it }
    }

    number?.let { n ->
        n.length?.let { map["number length"] = it.toString() }
        n.luhn?.let { map["number luhn"] = it.toString() }
    }

    return map
}

fun CardInfoUi.toEntity(): CardInfoEntity {

    return CardInfoEntity(
        bin = bin,
        brand = brand,
        prepaid = prepaid,
        scheme = scheme,
        type = type,
        bankCity = bank?.city,
        bankName = bank?.name,
        bankPhone = bank?.phone,
        bankUrl = bank?.url,
        numberLuhn = number?.luhn,
        numberLength = number?.length,
        countryName = country?.name,
        countryCurrency = country?.currency,
        countryLatitude = country?.latitude,
        countryLongitude = country?.longitude,
        countryAlpha2 = country?.alpha2,
        countryEmoji = country?.emoji,
        countryNumeric = country?.numeric
    )

}