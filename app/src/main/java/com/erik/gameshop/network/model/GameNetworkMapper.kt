package com.erik.gameshop.network.model

import com.erik.gameshop.domain.model.Game
import com.erik.gameshop.domain.util.EntityMapper

class GameNetworkMapper : EntityMapper<GameNetworkEntity, Game>{

    override fun mapFromEntity(entity: GameNetworkEntity): Game {
        return Game(
            id = entity.id ,
            slug = entity.slug,
            name = entity.name,
            description_raw = entity.description_raw,
            metacritic = entity.metacritic,
            released = entity.released,
            background_image = entity.background_image,
            website = entity.website,
            rating = entity.rating,
            rating_top = entity.rating_top
        )
    }

    override fun mapToEntity(domainModel: Game): GameNetworkEntity {
        return GameNetworkEntity(
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

    fun fromEntityList(initial: List<GameNetworkEntity>) : List<Game>{
        return initial.map { mapFromEntity(it) }
    }

    fun toEntityList(initial: List<Game>):List<GameNetworkEntity>{
        return initial.map { mapToEntity(it) }
    }

}