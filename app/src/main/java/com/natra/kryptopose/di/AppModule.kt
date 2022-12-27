package com.natra.kryptopose.di

import com.natra.kryptopose.common.Constants
import com.natra.kryptopose.data.remote.CoinPaprikaApi
import com.natra.kryptopose.data.repository.CoinRepositoryImpl
import com.natra.kryptopose.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(api: CoinPaprikaApi): CoinRepository{
        return CoinRepositoryImpl(api)
    }
}