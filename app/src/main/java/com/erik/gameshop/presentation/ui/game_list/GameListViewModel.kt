package com.erik.gameshop.presentation.ui.game_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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

    val page = mutableStateOf(1)

    private var gameScrollPosition = 0

     val PAGE_SIZE = 20

    init {
        newSearch()
    }

    private fun newSearch(){
        viewModelScope.launch{
            val result = repository.getAllGames(
                token = token,
                page = 1,
            )
            games.value = result
        }
    }

    fun nextPage(){
        viewModelScope.launch {
            //prevent duplicate events due to recompose happening
            if((gameScrollPosition + 1) >= (page.value * PAGE_SIZE)){
                incrementPage()

                if(page.value > 1){
                    viewModelScope.launch {
                        val result = repository.getAllGames(
                            token = token,
                            page = page.value,
                        )
                        appendGames(result)
                    }
                }

            }
        }
    }

    //Append new games to the current list of games
    private fun appendGames(games: List<Game>){
        val current = ArrayList(this.games.value)
        current.addAll(games)
        this.games.value = current
    }

    private fun incrementPage(){
        page.value = page.value + 1
    }

    fun onChangeGameScrollPosition(position: Int){
        gameScrollPosition = position
    }



}