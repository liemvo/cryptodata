package com.antonicastejon.cryptodata.di

import com.antonicastejon.cryptodata.CryptoApplication
import com.antonicastejon.cryptodata.presentation.main.di.MainActivityModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelFactoryModule::class,
        NetModule::class,
        RepositoryModule::class,
        UseCasesModule::class,
        ViewModelModule::class,
        MainActivityModule::class
        ])
interface ApplicationComponent {
    fun inject(app: CryptoApplication)
}