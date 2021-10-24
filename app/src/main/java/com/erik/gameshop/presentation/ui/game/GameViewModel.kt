package com.erik.gameshop.presentation.ui.game

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.erik.gameshop.domain.model.Game
import com.erik.gameshop.repository.GameRepository
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named
import androidx.lifecycle.viewModelScope
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import java.lang.Exception

const val STATE_KEY_RECEIPE = "com.erik.gameshop.presentation.ui.game.gameID"

@HiltViewModel
class GameViewModel
@Inject
constructor(
    private val gameRepository: GameRepository,
    @Named("auth_token") private val token: String

): ViewModel() {

    val game: MutableState<Game?> = mutableStateOf(null)

    val loading = mutableStateOf(false)

    fun onTriggerEvent(event: GameEvent){
        viewModelScope.launch {
            try {
                when(event){
                    is GameEvent.GetGameEvent -> {
                        if(game.value == null){
                            getGame(event.id)

                        }
                    }
                }
            }catch (e: Exception){
                Log.e("GameViewModel"," Exception $e")
            }
        }
    }

    private suspend fun getGame(id: Int){
        loading.value = true

        val game = gameRepository.getGameById(token,id)
        this.game.value = game

        loading.value = false
    }

}