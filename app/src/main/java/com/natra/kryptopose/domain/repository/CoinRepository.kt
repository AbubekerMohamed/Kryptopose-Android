package com.natra.kryptopose.domain.repository

import com.natra.kryptopose.data.remote.dto.CoinDetailDto
import com.natra.kryptopose.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}