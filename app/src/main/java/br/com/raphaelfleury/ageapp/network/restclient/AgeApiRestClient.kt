package br.com.raphaelfleury.ageapp.network.restclient

import retrofit2.http.GET
import retrofit2.http.Path
import br.com.raphaelfleury.ageapp.models.AgeResponse
import retrofit2.http.Query

interface AgeApiRestClient {
    @GET("players/{playerId}")
    suspend fun getAgeApi(
        @Path("playerId") playerId: String
    ): AgeResponse
}