package com.erik.gameshop.presentation.ui.game_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erik.gameshop.domain.model.Game
import com.erik.gameshop.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class GameListViewModel
@Inject
constructor(
    private val repository: GameRepository,
    @Named("auth_token") private val token: String
) :ViewModel(){

    val games: MutableState<List<Game>>  = mutableStateOf(listOf())

    init {
        viewModelScope.launch{
            val result = repository.getAllGames(
                token = token,
                page = 1,
            )
            games.value = result
            println("HEREEEEEEEE: ${games.value}")
        }
    }

}