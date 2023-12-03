package com.nimesh.cruptocurrencyapp.presentation.coin_detail

import com.nimesh.cruptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
