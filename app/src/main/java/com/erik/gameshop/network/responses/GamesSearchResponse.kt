package com.erik.gameshop.network.responses

import com.erik.gameshop.network.model.GameNetworkEntity
import com.google.gson.annotations.SerializedName

class GamesSearchResponse (

    @SerializedName(value = "count")
    var count: Int,

    @SerializedName(value = "results")
    var games: List<GameNetworkEntity>


)