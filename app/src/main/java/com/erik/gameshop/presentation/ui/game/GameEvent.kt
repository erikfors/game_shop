package com.erik.gameshop.presentation.ui.game

sealed class GameEvent {

    data class GetGameEvent(
        val id: Int
    ):GameEvent()
}