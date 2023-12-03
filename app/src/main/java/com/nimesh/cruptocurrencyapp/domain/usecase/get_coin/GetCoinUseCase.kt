package com.nimesh.cruptocurrencyapp.domain.usecase.get_coin

import com.nimesh.cruptocurrencyapp.common.Resource
import com.nimesh.cruptocurrencyapp.data.remote.dto.toCoinDetail
import com.nimesh.cruptocurrencyapp.domain.model.CoinDetail
import com.nimesh.cruptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = coinRepository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. check your internet connection."))
        }
    }
}