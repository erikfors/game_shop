package com.erik.gameshop.repository

import com.erik.gameshop.domain.model.Game
import com.erik.gameshop.network.model.GameDto

interface GameRepository {

    suspend fun getAllGames(token: String, page: Int): List<Game>

    suspend fun getGameById(token: String, gameId: Int): Game
}