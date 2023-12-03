package com.nimesh.cruptocurrencyapp.presentation.coin_list

import com.nimesh.cruptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
