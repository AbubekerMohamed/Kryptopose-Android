package com.natra.kryptopose.data.remote

import com.natra.kryptopose.data.remote.dto.CoinDetailDto
import com.natra.kryptopose.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinPaprikaApi {
    //fetches all coins
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>
    //fetches details of a coin
    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}