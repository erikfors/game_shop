package com.erik.gameshop.presentation.ui.game_list

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.erik.gameshop.R
import com.erik.gameshop.presentation.components.GameCard
import dagger.hilt.android.AndroidEntryPoint
import com.erik.gameshop.ui.theme.Grey700

@AndroidEntryPoint
class GameListFragment : Fragment() {

    private val viewModel: GameListViewModel by viewModels()
    private val TAG = "GameListFragment"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val page = viewModel.page.value

        return ComposeView(requireContext()).apply {
            setContent {

                val games = viewModel.games.value

                Column() {
                    LazyColumn(
                        modifier = Modifier
                            .padding(16.dp),
                    ) {
                        itemsIndexed(
                            items = games
                        ) { index, game ->
                            viewModel
                                .onChangeGameScrollPosition(index)
                            if ((index + 1) >= (page * PAGE_SIZE)) {
                                viewModel.nextPage()
                            }
                            GameCard(game = game,
                                onClick = {
                                        val bundle = Bundle()
                                        bundle.putParcelable("game", game)
                                        findNavController().navigate(R.id.action_gameListFragment_to_gameFragment,bundle)
                                })
                        }
                    }
                }


            }
        }
    }
}