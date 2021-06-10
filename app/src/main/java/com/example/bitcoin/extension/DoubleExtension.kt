package com.example.bitcoin.extension

import java.text.NumberFormat
import java.util.*

fun Double?.orZero() = this?: 0.0

fun Double?.toCurrency():String {
    val locale = Locale("en", "US")
    return NumberFormat.getCurrencyInstance(locale)
        .format(this.orZero())
        .orEmpty()
}

fun Double.changeRateOf(number:Double):Double =
    (((number.minus(this)).div(this)).times(100)).round(2)

fun Double.round(decimals:Int = 2):Double =
    "%.${decimals}f".format(Locale("en", "US"), this).toDouble()


