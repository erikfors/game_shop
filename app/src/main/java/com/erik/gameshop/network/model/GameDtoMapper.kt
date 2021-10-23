package com.erik.gameshop.network.model

import com.erik.gameshop.domain.model.Game
import com.erik.gameshop.domain.util.DomainMapper

class GameDtoMapper : DomainMapper<GameDto, Game>{

    override fun mapToDomainModel(model: GameDto): Game {
        return Game(
            id = model.id ,
            slug = model.slug,
            name = model.name,
            description_raw = model.description_raw,
            metacritic = model.metacritic,
            released = model.released,
            background_image = model.background_image,
            website = model.website,
            rating = model.rating,
            rating_top = model.rating_top
        )
    }

    override fun mapFromDomainModel(domainModel: Game): GameDto {
        return GameDto(
            id = domainModel.id ,
            slug = domainModel.slug,
            name = domainModel.name,
            description_raw = domainModel.description_raw,
            metacritic = domainModel.metacritic,
            released = domainModel.released,
            background_image = domainModel.background_image,
            website = domainModel.website,
            rating = domainModel.rating,
            rating_top = domainModel.rating_top
        )
    }

    fun toDomainList(initial: List<GameDto>) : List<Game>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Game>):List<GameDto>{
        return initial.map { mapFromDomainModel(it) }
    }

}