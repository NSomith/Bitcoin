package com.example.bitcoin.domain.usecase

import com.example.bitcoin.State
import com.example.bitcoin.domain.modal.MarketInformation
import com.example.bitcoin.domain.modal.MarketInformationTimespan
import kotlinx.coroutines.flow.Flow

interface MarketInformationUseCase {
    fun getMarketInformation(timespan: MarketInformationTimespan): Flow<State<MarketInformation>>
}