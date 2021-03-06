package com.example.bitcoin.remote.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class MarketPriceValueResponse(
    @Json(name = "x")
    val timestamp: Int,
    @Json(name = "y")
    val price: Double
)