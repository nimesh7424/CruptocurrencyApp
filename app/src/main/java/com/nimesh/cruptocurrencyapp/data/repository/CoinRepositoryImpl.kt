package com.nimesh.cruptocurrencyapp.data.repository

import com.nimesh.cruptocurrencyapp.data.remote.CoinPaprikaApi
import com.nimesh.cruptocurrencyapp.data.remote.dto.CoinDetailDto
import com.nimesh.cruptocurrencyapp.data.remote.dto.CoinDto
import com.nimesh.cruptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> = coinPaprikaApi.getCoins()

    override suspend fun getCoinById(coinId: String): CoinDetailDto = coinPaprikaApi.getCoinById(coinId)
}