package com.natra.kryptopose.domain.use_case.get_coin

import com.natra.kryptopose.common.Resource
import com.natra.kryptopose.data.remote.dto.toCoin
import com.natra.kryptopose.data.remote.dto.toCoinDetail
import com.natra.kryptopose.domain.model.Coin
import com.natra.kryptopose.domain.model.CoinDetail
import com.natra.kryptopose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))

        } catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Unexpected Error Occurred"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server, check your connection."))
        }
    }
}