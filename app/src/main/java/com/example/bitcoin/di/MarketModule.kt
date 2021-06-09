package com.example.bitcoin.di

import com.example.bitcoin.domain.usecase.MarketInformationUseCase
import com.example.bitcoin.domain.usecase.MarketInformationUseCaseImpl
import com.example.bitcoin.remote.MarketRepository
import com.example.bitcoin.remote.MarketRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MarketModule {

    @Binds
    abstract fun provideMarketRepo(
        marketRepositoryImp: MarketRepositoryImp
    ): MarketRepository

    @Binds
    abstract fun provideMarketPriceUseCase(
        marketInformationUseCaseImpl: MarketInformationUseCaseImpl
    ): MarketInformationUseCase

}