package com.erik.gameshop.presentation.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erik.gameshop.R
import com.erik.gameshop.domain.model.Game
import com.erik.gameshop.ui.theme.*
import com.erik.gameshop.util.LOADING_IMAGE_SPINNER
import com.erik.gameshop.util.loadPicture

@Composable
fun GameCard(
    game: Game,
    onClick: () -> Unit,
) {
    Card(
        shape = Shapes.medium,
        backgroundColor = Grey500,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
            )
            .fillMaxHeight()
            .clickable(onClick = onClick),
        elevation = 8.dp,

        ) {
        Column() {
            game.background_image?.let { url ->
                val image = loadPicture(url = url, defaultImage = LOADING_IMAGE_SPINNER).value
                image?.let { img ->
                    Image(
                        image.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

            }
            game.name?.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 8.dp)
                ) {
                    Text(
                        text = title,
                        Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = Typography.h1
                    )

                    game.metacritic?.let { metRat ->

                        var metaColor = Green500

                        if (game.metacritic < 75) {
                            metaColor = Orange500
                        }

                        Text(
                        text = game.metacritic.toString(),
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
                    ) }

                }
            }
        }
    }
}