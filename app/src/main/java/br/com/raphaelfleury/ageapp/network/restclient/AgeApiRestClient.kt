package br.com.raphaelfleury.ageapp.network.restclient

import br.com.raphaelfleury.ageapp.models.game.Games
import retrofit2.http.GET
import retrofit2.http.Query

interface AgeApiRestClient {
    @GET("games")
    suspend fun getAgeApi(
        @Query("profile_ids") playerId: String
    ): Games
}