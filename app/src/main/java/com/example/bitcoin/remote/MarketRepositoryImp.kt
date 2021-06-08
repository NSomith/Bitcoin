package com.example.bitcoin.remote

import com.example.bitcoin.BaseRepo
import com.example.bitcoin.State
import com.example.bitcoin.remote.response.MarketPriceChartResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MarketRepositoryImp @Inject constructor(
    val marketRemoteDataSource: MarketRemoteDataSource
) : BaseRepo(), MarketRepository {
    override fun fetchMarketPriceChart(timespan: String): Flow<State<MarketPriceChartResponse>> =
        apicall {
            marketRemoteDataSource.fetchMarketPriceChart(timespan)
        }


}