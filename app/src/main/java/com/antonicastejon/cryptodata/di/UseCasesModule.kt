package com.antonicastejon.cryptodata.di

import com.antonicastejon.cryptodata.domain.CryptoListInteractor
import com.antonicastejon.cryptodata.domain.CryptoListUseCases
import com.antonicastejon.cryptodata.model.CoinMarketCapRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCasesModule {

    @Singleton
    @Provides
    fun providesCryptoListUseCases(coinMarketCapRepository: CoinMarketCapRepository): CryptoListUseCases = CryptoListInteractor(coinMarketCapRepository)
}