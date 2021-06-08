package com.example.bitcoin.remote.di

import com.example.bitcoin.remote.MarketAPi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    private const val BLOCKCHAIN_API_URL = "https://api.blockchain.info/"

    @Singleton
    @Provides
    fun provideRetrofit(
        blockchainApiUrl: String,
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): MarketAPi =
        Retrofit.Builder()
            .baseUrl(blockchainApiUrl)
            .addConverterFactory(moshiConverterFactory)
            .client(okHttpClient)
            .build()
            .create(MarketAPi::class.java)

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    fun provideBlockChainApiUrl(): String = BLOCKCHAIN_API_URL

    @Singleton
    @Provides
    fun provideMosiConvertorFactory(): MoshiConverterFactory = MoshiConverterFactory.create()

    @Singleton
    @Provides
    fun provideHttpLoginInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BASIC)
    }
}