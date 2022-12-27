package com.natra.kryptopose.data.repository

import com.natra.kryptopose.data.remote.CoinPaprikaApi
import com.natra.kryptopose.data.remote.dto.CoinDetailDto
import com.natra.kryptopose.data.remote.dto.CoinDto
import com.natra.kryptopose.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}