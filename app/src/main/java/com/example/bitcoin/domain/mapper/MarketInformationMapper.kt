package com.example.bitcoin.domain.mapper

import androidx.annotation.VisibleForTesting
import com.example.bitcoin.domain.modal.MarketInformation
import com.example.bitcoin.domain.modal.MarketInformationChangeStatus
import com.example.bitcoin.domain.modal.MarketInformationTimespan
import com.example.bitcoin.extension.changeRateOf
import com.example.bitcoin.extension.orZero
import com.example.bitcoin.extension.toCurrency
import com.example.bitcoin.remote.response.MarketPriceChartResponse
import com.example.bitcoin.remote.response.MarketPriceValueResponse
import com.github.mikephil.charting.data.Entry
import javax.inject.Inject

class MarketInformationMapper @Inject constructor() {
    fun mapOnMarketPriceChartResponse(
        marketPriceChartResponse: MarketPriceChartResponse,
        timespan: MarketInformationTimespan
    ): MarketInformation {
        val prices = marketPriceChartResponse.values.map {
            it.price
        }
        val firstPrice = prices.firstOrNull().orZero()
        val lastPrice = prices.lastOrNull().orZero()

        return MarketInformation(
            currentPrice = lastPrice.toCurrency(),
            openPrice = firstPrice.toCurrency(),
            closePrice = lastPrice.toCurrency(),
            highPrice = prices.maxOrNull().toCurrency(),
            lowPrice = prices.minOrNull().toCurrency(),
            averagePrice = prices.average().toCurrency(),
            changePrice = (lastPrice.minus(firstPrice)).toCurrency(),
            changeRate = "${firstPrice.changeRateOf(lastPrice)}%",
            changeStatus = getChangeStatus(firstPrice, lastPrice),
            aboutChart = marketPriceChartResponse.description,
            timespan = timespan,
            chartEntries = marketPriceChartResponse.values.map { mapOnMarketPriceValueResponse(it) }
        )
    }


    fun mapOnMarketPriceValueResponse(marketPriceValueResponse: MarketPriceValueResponse) =
        Entry(
            marketPriceValueResponse.timestamp.toFloat(),
            marketPriceValueResponse.price.toFloat()
        )


    fun getChangeStatus(firstPrice: Double, lastPrice: Double) =
        if (lastPrice >= firstPrice) {
            MarketInformationChangeStatus.POSITIVE
        } else {
            MarketInformationChangeStatus.NEGATIVE
        }
}