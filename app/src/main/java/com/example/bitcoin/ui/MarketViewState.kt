package com.example.bitcoin.ui

import android.content.Context
import com.example.bitcoin.R
import com.example.bitcoin.domain.modal.MarketInformation
import com.example.bitcoin.domain.modal.MarketInformationChangeStatus
import com.example.bitcoin.domain.modal.MarketInformationTimespan
import com.example.bitcoin.extension.getCompatColor
import com.example.bitcoin.extension.getCompatDrawable
import com.github.mikephil.charting.data.LineDataSet

class MarketViewState(
    val marketInformation: MarketInformation
) {
    fun getLineDataSet(context: Context) =
        LineDataSet(marketInformation.chartEntries, "market_price").apply {
            mode = LineDataSet.Mode.CUBIC_BEZIER
            color = getColor(context)
            highLightColor =getColor(context)
            fillDrawable =getBackground(context)
            setDrawCircles(true)
            setDrawFilled(true)
        }

    fun getColor(context: Context) =
        if (marketInformation.changeStatus == MarketInformationChangeStatus.POSITIVE) {
            context.getCompatColor(R.color.green_500)
        } else {
            context.getCompatColor(R.color.red_500)
        }

    fun getBackground(context: Context) =
        if (marketInformation.changeStatus == MarketInformationChangeStatus.POSITIVE) {
            context.getCompatDrawable(R.drawable.background_positive_chart)
        } else {
            context.getCompatDrawable(R.drawable.background_negative_chart)
        }

    fun isChip1dChecked() = marketInformation.timespan == MarketInformationTimespan.TIMESPAN_1DAYS

    fun isChip7dChecked() = marketInformation.timespan == MarketInformationTimespan.TIMESPAN_7DAYS

    fun isChip30dChecked() = marketInformation.timespan == MarketInformationTimespan.TIMESPAN_30DAYS

    fun isChip60dChecked() = marketInformation.timespan == MarketInformationTimespan.TIMESPAN_60DAYS

    fun isChip90dChecked() = marketInformation.timespan == MarketInformationTimespan.TIMESPAN_90DAYS

    fun isChip1yChecked() = marketInformation.timespan == MarketInformationTimespan.TIMESPAN_1YEAR
}