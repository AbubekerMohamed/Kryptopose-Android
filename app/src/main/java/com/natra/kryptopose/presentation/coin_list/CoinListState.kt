package com.natra.kryptopose.presentation.coin_list

import com.natra.kryptopose.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
