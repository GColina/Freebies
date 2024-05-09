package com.gcolina.freebies.util

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gcolina.freebies.R
import com.gcolina.freebies.util.Constant.Companion.GRADIENT_COLORS

@Suppress("ktlint:standard:function-naming")
@Composable
fun CommonCardAnimation(
    title: String,
    imageCard: String,
    shortDetail: String,
    navigateToDetail: () -> Unit,
) {
    var showExtra by rememberSaveable { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(Color.White),
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp)
                .clickable { showExtra = !showExtra }
                .animateContentSize(
                    animationSpec =
                        tween(
                            durationMillis = 300,
                            easing = LinearOutSlowInEasing,
                        ),
                ),
        shape = RoundedCornerShape(topEnd = 20.dp),
        elevation = CardDefaults.outlinedCardElevation(8.dp),
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card(
                shape = RoundedCornerShape(topEnd = 20.dp),
                modifier =
                    Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp, top = 5.dp),
            ) {
                ShowImageWhitCoil(
                    image = imageCard,
                )
            }
            Text(
                text = title,
                fontSize = 25.sp,
                style =
                    TextStyle(
                        brush =
                            Brush.linearGradient(
                                // Esta definido dentro de la carpeta util en las constantes
                                colors = GRADIENT_COLORS,
                            ),
                    ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(5.dp),
            )
            if (showExtra) {
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = shortDetail,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f),
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_rigth_arrow),
                        contentDescription = null,
                        modifier =
                            Modifier
                                .weight(0.1f)
                                .clickable { navigateToDetail() },
                    )
                }
            } else {
                Image(
                    painter = painterResource(id = R.drawable.ic_expand),
                    contentDescription = null,
                )
            }
        }
    }
}
