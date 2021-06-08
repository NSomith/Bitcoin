package com.example.bitcoin.remote

import com.example.bitcoin.State
import com.example.bitcoin.remote.response.MarketPriceChartResponse
import kotlinx.coroutines.flow.Flow

interface MarketRepository {
    fun fetchMarketPriceChart(timespan:String): Flow<State<MarketPriceChartResponse>>
}