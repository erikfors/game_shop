package com.erik.gameshop.network.services

import com.erik.gameshop.network.model.GameNetworkEntity
import com.erik.gameshop.network.responses.GamesSearchResponse
import retrofit2.http.*

interface GameService {

    @GET(value = "games")
    suspend fun getAllGames(
        @Query(value = "key") token: String
    ): GamesSearchResponse

    @GET(value = "games/{gameID}")
    suspend fun getGameById(
        @Path("gameID") gameId: Int,
        @Query(value = "key") token: String,
    ): GameNetworkEntity
}