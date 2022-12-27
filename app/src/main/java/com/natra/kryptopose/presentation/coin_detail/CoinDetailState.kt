package com.natra.kryptopose.presentation.coin_detail

import com.natra.kryptopose.domain.model.Coin
import com.natra.kryptopose.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
