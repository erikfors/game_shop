package com.erik.gameshop.presentation.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.fragment.app.viewModels
import com.erik.gameshop.domain.model.Game
import com.erik.gameshop.ui.theme.Green500
import com.erik.gameshop.ui.theme.Orange500
import com.erik.gameshop.ui.theme.Typography
import com.erik.gameshop.util.LOADING_IMAGE_SPINNER
import com.erik.gameshop.util.loadPicture
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameFragment : Fragment() {

    private var currentGame = Game()

    private val viewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getParcelable<Game>("game").let { game ->
            if (game != null) {
                this.currentGame = game
                game.id?.let { GameEvent.GetGameEvent(it) }?.let { viewModel.onTriggerEvent(it) }
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val loading = viewModel.loading.value

                viewModel.game.value?.let { game ->
                    currentGame = game
                }

                LazyColumn() {
                    item { currentGame.background_image?.let { url ->
                        val image =
                            loadPicture(url = url, defaultImage = LOADING_IMAGE_SPINNER).value
                        image?.let { img ->
                            Image(
                                image.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                    }
                        Column(modifier = Modifier.padding(16.dp)) {
                            currentGame.name?.let { title ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 12.dp, top = 8.dp, bottom = 12.dp)

                                ) {
                                    Text(
                                        text = title,
                                        Modifier
                                            .fillMaxWidth(0.85f)
                                            .wrapContentWidth(Alignment.Start)
                                            .align(Alignment.CenterVertically),
                                        style = Typography.h1
                                    )

                                    currentGame.metacritic?.let { metRat ->

                                        var metaColor = Green500

                                        if (currentGame.metacritic!! < 75) {
                                            metaColor = Orange500
                                        }

                                        Text(
                                            text = currentGame.metacritic.toString(),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentWidth(Alignment.End)
                                                .border(1.dp, metaColor)
                                                .padding(horizontal = 8.dp, vertical = 4.dp)
                                                .align(Alignment.CenterVertically),
                                            style = TextStyle(
                                                fontFamily = FontFamily.Default,
                                                fontWeight = FontWeight.Normal,
                                                fontSize = 18.sp,
                                                color = metaColor
                                            )
                                        )
                                    }

                                }
                            }
                            currentGame.released?.let { released ->
                                Text(text = "Released date:", style = Typography.h2,)
                                Text(text = released,style = Typography.body1)
                                Divider(modifier = Modifier.padding(bottom = 8.dp))
                            }
                            currentGame.website?.let { web ->
                                Text(text = "Website:", style = Typography.h2,)
                                Text(text = web,style = Typography.body1)
                                Divider(modifier = Modifier.padding(bottom = 8.dp))
                            }
                            currentGame.rating?.let { rating ->
                                currentGame.rating_top?.let { ratingTop ->
                                    Text(text = "Rating:", style = Typography.h2,)
                                    Text(text = "$rating out of $ratingTop",style = Typography.body1)
                                    Divider(modifier = Modifier.padding(bottom = 8.dp))
                                }
                            }
                            currentGame.description_raw?.let { description ->
                                Text(text = "About:", style = Typography.h2,)
                                Text(text = description,style = Typography.body1)
                                Divider(modifier = Modifier.padding(bottom = 8.dp))
                            }




                        }  }

                }


            }
        }
    }
}