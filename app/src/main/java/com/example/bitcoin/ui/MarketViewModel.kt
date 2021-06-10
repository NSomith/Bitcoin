package com.example.bitcoin.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bitcoin.domain.modal.MarketInformation
import com.example.bitcoin.domain.usecase.MarketInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MarketViewModel @Inject constructor(
    val marketInformationUseCase: MarketInformationUseCase
) :ViewModel(){
    private val marketViewStateLiveData = MutableLiveData<MarketViewState>()
    
}