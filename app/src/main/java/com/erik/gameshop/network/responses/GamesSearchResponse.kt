package com.erik.gameshop.network.responses

import com.erik.gameshop.network.model.GameDto
import com.google.gson.annotations.SerializedName

data class GamesSearchResponse (

    @SerializedName(value = "count")
    var count: Int,

    @SerializedName(value = "results")
    var games: List<GameDto>


)