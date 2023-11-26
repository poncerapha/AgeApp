package br.com.raphaelfleury.ageapp.repository

import br.com.raphaelfleury.ageapp.models.game.Games
import br.com.raphaelfleury.ageapp.network.restclient.AgeApiRestClient
import br.com.raphaelfleury.ageapp.util.Resource
import javax.inject.Inject

class AgeRepository @Inject constructor(
    private val ageApiRestClient: AgeApiRestClient
) {
    suspend fun getAgePlayerInfo(playerId: String): Resource<Games> {
        val response = try {
            ageApiRestClient.getAgeApi(playerId)
        } catch (e: Exception) {
            return Resource.Error("An unkown error occured")
        }

        return Resource.Success(response)
    }
}