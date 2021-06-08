package com.example.bitcoin.remote

import com.example.bitcoin.remote.response.MarketPriceChartResponse
import javax.inject.Inject

class MarketRemoteDataSource @Inject constructor(
    val marketAPi: MarketAPi
) {
    suspend fun fetchMarketPriceChart(timeSpna: String): MarketPriceChartResponse =
        marketAPi.fetchMarketPriceChart(timeSpna)
}