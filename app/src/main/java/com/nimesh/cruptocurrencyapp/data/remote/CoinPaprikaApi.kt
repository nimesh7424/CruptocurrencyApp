package com.nimesh.cruptocurrencyapp.data.remote

import com.nimesh.cruptocurrencyapp.common.Resource
import com.nimesh.cruptocurrencyapp.data.remote.dto.CoinDetailDto
import com.nimesh.cruptocurrencyapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String) : CoinDetailDto
}