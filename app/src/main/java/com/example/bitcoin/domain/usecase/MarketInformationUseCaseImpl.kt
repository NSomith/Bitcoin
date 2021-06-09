package com.example.bitcoin.domain.usecase

import com.example.bitcoin.State
import com.example.bitcoin.domain.mapper.MarketInformationMapper
import com.example.bitcoin.domain.modal.MarketInformation
import com.example.bitcoin.domain.modal.MarketInformationTimespan
import com.example.bitcoin.extension.map
import com.example.bitcoin.remote.MarketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MarketInformationUseCaseImpl @Inject constructor(
    private val marketRepo: MarketRepository,
    private val marketModalMapper: MarketInformationMapper
) : MarketInformationUseCase {
    override fun getMarketInformation(timespan: MarketInformationTimespan): Flow<State<MarketInformation>> =
        marketRepo.fetchMarketPriceChart(timespan.value).map {state->
            state.map {
                marketModalMapper.mapOnMarketPriceChartResponse(
                    it,
                    timespan
                )
            }
        }

}


