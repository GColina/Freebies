package com.gcolina.freebies.util

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomButton(
    title: String,
    textColor: Color,
    colorBackground: Color,
    textSize: Int,
    modifier: Modifier
) {
    Card(
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(colorBackground),
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Text(
            text = title,
            fontSize = textSize.sp,
            color = textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                start = 10.dp,
                end = 10.dp,
                top = 3.dp,
                bottom = 3.dp
            ).align(Alignment.CenterHorizontally)

        )
    }
}

@Composable
fun CustomEmptyButton(
    title: String,
    textColor: Color,
    colorBackground: Color,
    textSize: Int,
    modifier: Modifier
) {
    Card(
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(colorBackground),
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        border = BorderStroke(1.dp, color = textColor)
    ) {
        Text(
            text = title,
            fontSize = textSize.sp,
            color = textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                start = 10.dp,
                end = 10.dp,
                top = 3.dp,
                bottom = 3.dp
            ).align(Alignment.CenterHorizontally)

        )
    }
}