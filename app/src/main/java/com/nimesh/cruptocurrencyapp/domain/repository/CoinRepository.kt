package com.nimesh.cruptocurrencyapp.domain.repository

import com.nimesh.cruptocurrencyapp.data.remote.dto.CoinDetailDto
import com.nimesh.cruptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}