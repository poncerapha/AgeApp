package br.com.raphaelfleury.ageapp.repository

import br.com.raphaelfleury.ageapp.models.AgeResponse
import br.com.raphaelfleury.ageapp.network.restclient.AgeApiRestClient
import br.com.raphaelfleury.ageapp.util.Resource
import java.lang.Exception
import javax.inject.Inject

class AgeRepository @Inject constructor(
    private val ageApiRestClient: AgeApiRestClient
) {
    suspend fun getAgePlayerInfo(playerId: String): Resource<AgeResponse> {
        val response = try {
            ageApiRestClient.getAgeApi(playerId)
        } catch (e: Exception) {
            return Resource.Error("An unkown error occured")
        }

        return Resource.Success(response)
    }
}