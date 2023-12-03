package com.nimesh.cruptocurrencyapp.domain.usecase.get_coins

import com.nimesh.cruptocurrencyapp.common.Resource
import com.nimesh.cruptocurrencyapp.data.remote.dto.toCoin
import com.nimesh.cruptocurrencyapp.domain.model.Coin
import com.nimesh.cruptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. check your internet connection."))
        }
    }
}