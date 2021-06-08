package com.example.bitcoin.remote.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class MarketPriceChartResponse(
    @Json(name = "description")
    val description: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "period")
    val period: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "unit")
    val unit: String,
    @Json(name = "values")
    val values: List<MarketPriceValueResponse>
)