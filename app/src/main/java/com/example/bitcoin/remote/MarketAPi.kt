package com.example.bitcoin.remote

import com.example.bitcoin.remote.response.MarketPriceChartResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketAPi {
    @GET
    suspend fun fetchMarketPriceChart(@Query("timespan") timespan: String): MarketPriceChartResponse
}