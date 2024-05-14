@file:Suppress("ktlint:standard:filename")

package com.gcolina.freebies.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gcolina.freebies.R

@Composable
fun CommonCard(name: String, imageCard: String) {
    Card(
        colors = CardDefaults.cardColors(White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 20.dp),
        shape = RoundedCornerShape(topEnd = 20.dp),
        elevation = CardDefaults.outlinedCardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(topEnd = 20.dp),
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp, top = 5.dp)
            ) {
                ShowImageWhitCoil(
                    image = imageCard
                )
            }
            Text(
                text = name,
                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.josefinsans_semibold)),
                style = TextStyle(
                    brush = Brush.linearGradient(
                        // Esta definido dentro de la carpeta util en las constantes
                        colors = Constant.GRADIENT_COLORS
                    )
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

    /*Row(modifier = Modifier.fillMaxWidth()) {
        Card(
            colors = CardDefaults.cardColors(White),
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
                .padding(5.dp),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.outlinedCardElevation(8.dp),
            border = BorderStroke(2.dp, Black)
        ) { Text(text = "name", modifier = Modifier.padding(5.dp)) }
        Card(
            colors = CardDefaults.cardColors(White),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(5.dp),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.outlinedCardElevation(8.dp),
            border = BorderStroke(2.dp, Black)
        ) { Text(text = "Card Blue", modifier = Modifier.padding(5.dp)) }
    }*/
