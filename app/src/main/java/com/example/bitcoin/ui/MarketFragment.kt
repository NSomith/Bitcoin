package com.example.bitcoin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bitcoin.R
import com.example.bitcoin.databinding.FragmentMarketBinding
import com.example.bitcoin.extension.inflate

class MarketFragment:Fragment() {
    lateinit var marketBinding: FragmentMarketBinding
    private val marketViewModel :MarketViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        marketBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_market,container,false)
        return marketBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupobservers()
    }

    private fun inflaterLayoutError(layoutViewState: LayoutViewState) {
        marketBinding.layoutError.viewStub?.inflate(layoutViewState.isError())
    }

    private fun setupobservers() {
        marketViewModel.layoutViewState.observe(viewLifecycleOwner,{
            marketBinding.layoutViewState =it
            inflaterLayoutError(it)
//            marketBinding.executePendingBindings()
        })

        marketViewModel.marketViewStateLiveData.observe(viewLifecycleOwner,{
            marketBinding.viewState = it

        })

    }
}