package com.erik.gameshop.repository

import com.erik.gameshop.domain.model.Game
import com.erik.gameshop.network.model.GameDto
import com.erik.gameshop.network.model.GameDtoMapper
import com.erik.gameshop.network.services.GameService

class GameRepositoryImplementation(
    private val gameService: GameService,
    private val mapper: GameDtoMapper
) : GameRepository{

    override suspend fun getAllGames(token: String, page: Int): List<Game> {
        return mapper.toDomainList(gameService.getAllGames(token, page).games)
    }

    override suspend fun getGameById(token: String, gameId: Int): Game {
       return mapper.mapToDomainModel(gameService.getGameById(gameId,token))
    }
}