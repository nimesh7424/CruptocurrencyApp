package com.nimesh.cruptocurrencyapp.di

import com.nimesh.cruptocurrencyapp.common.Constants.BASE_URL
import com.nimesh.cruptocurrencyapp.data.remote.CoinPaprikaApi
import com.nimesh.cruptocurrencyapp.data.repository.CoinRepositoryImpl
import com.nimesh.cruptocurrencyapp.domain.repository.CoinRepository
import com.nimesh.cruptocurrencyapp.domain.usecase.get_coin.GetCoinUseCase
import com.nimesh.cruptocurrencyapp.domain.usecase.get_coins.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesGetCoinUseCase(repository: CoinRepository): GetCoinUseCase {
        return GetCoinUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesGetCoinsUseCase(repository: CoinRepository): GetCoinsUseCase {
        return GetCoinsUseCase(repository)
    }
}