package com.cardbin.feature_card_history.data.mapper

import com.cardbin.feature_card_history.data.local.room.CardInfoEntity
import com.cardbin.feature_card_history.domain.models.BankUi
import com.cardbin.feature_card_history.domain.models.CardInfoUi
import com.cardbin.feature_card_history.domain.models.CountryUi
import com.cardbin.feature_card_history.domain.models.NumberUi

fun CardInfoEntity.toDomain(): CardInfoUi {

    return CardInfoUi(

        brand = brand,
        bin = bin,
        prepaid = prepaid,
        scheme = scheme,
        type = type,
        bank = BankUi(
            city = bankCity,
            name = bankName,
            phone = bankPhone,
            url = bankUrl
        ),
        number = NumberUi(
            length = numberLength,
            luhn = numberLuhn
        ),
        country = CountryUi(
            alpha2 = countryAlpha2,
            currency = countryCurrency,
            latitude = countryLatitude,
            longitude = countryLongitude,
            emoji = countryEmoji,
            name = countryName,
            numeric = countryNumeric
        )
    )
}

fun CardInfoUi.toMap(): Map<String, String> {
    val map = mutableMapOf<String, String>()

    bin.let { map["bin"] = it }
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