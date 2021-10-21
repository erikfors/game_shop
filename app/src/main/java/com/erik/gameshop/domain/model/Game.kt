package com.erik.gameshop.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game (
    val id: Int? = null,
    val slug: String? = null,
    val name: String? = null,
    val description_raw: String? = null,
    val metacritic: Int? = null,
    //list of metacritic
    val released: String? = null,
    //tba
    val background_image: String? = null,
    val website: String? = null,
    val rating: String? = null,
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


) : Parcelable