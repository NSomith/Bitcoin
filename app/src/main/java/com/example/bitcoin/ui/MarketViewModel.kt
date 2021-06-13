package com.example.bitcoin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bitcoin.domain.modal.MarketInformation
import com.example.bitcoin.domain.modal.MarketInformationTimespan
import com.example.bitcoin.domain.usecase.MarketInformationUseCase
import com.example.bitcoin.extension.doOnSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MarketViewModel @Inject constructor(
    val marketInformationUseCase: MarketInformationUseCase
) : ViewModel() {

    private val _marketViewStateLiveData = MutableLiveData<MarketViewState>()
    val marketViewStateLiveData: LiveData<MarketViewState> = _marketViewStateLiveData

    private val _layoutViewState  = MutableLiveData<LayoutViewState>()
    val layoutViewState:LiveData<LayoutViewState> = _layoutViewState

    fun getInformation(timespan:MarketInformationTimespan){
        marketInformationUseCase.getMarketInformation(timespan)
            .doOnSuccess { marketInformation ->
                _marketViewStateLiveData.postValue(MarketViewState(marketInformation))
            }.onEach {
                _layoutViewState.postValue(LayoutViewState(it))
            }
            .launchIn(viewModelScope)
    }





}