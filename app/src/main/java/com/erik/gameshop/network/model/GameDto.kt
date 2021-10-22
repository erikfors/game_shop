package com.erik.gameshop.network.model

import com.google.gson.annotations.SerializedName

data class GameDto(

    @SerializedName(value = "id")
    val id: Int? = null,
    @SerializedName(value = "slug")
    val slug: String? = null,
    @SerializedName(value = "name")
    val name: String? = null,
    @SerializedName(value = "description_raw")
    val description_raw: String? = null,
    @SerializedName(value = "metacritic")
    val metacritic: Int? = null,
    //list of metacritic
    @SerializedName(value = "released")
    val released: String? = null,
    //tba
    @SerializedName(value = "background_image")
    val background_image: String? = null,
    @SerializedName(value = "website")
    val website: String? = null,
    @SerializedName(value = "rating")
    val rating: String? = null,
    @SerializedName(value = "rating_top")
    val rating_top: String? = null,
    //ratings list
    //rating counts
    //suggestions count
    //reviews count
    //parent platform
    //stores
    //genres
    //tags
    //publishers
)