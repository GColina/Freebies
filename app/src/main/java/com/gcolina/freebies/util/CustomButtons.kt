package com.gcolina.freebies.util

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gcolina.freebies.R

@Composable
fun CustomButton(
    title: String,
    textColor: Color,
    colorBackground: Color,
    textSize: Int,
    modifier: Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(colorBackground),
        modifier = modifier.clickable { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally // Center the contents vertically
        ) {
            Text(
                text = title,
                fontSize = textSize.sp,
                color = textColor,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.josefinsans_semibold)),
                modifier = Modifier
            )
        }
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
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        border = BorderStroke(1.dp, color = textColor)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // Center the contents vertically
        ) {
            Text(
                text = title,
                fontSize = textSize.sp,
                color = textColor,
                fontFamily = FontFamily(Font(R.font.josefinsans_semibold)),
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowCustomButton() {
    Column {
        CustomButton(
            title = "DOWNLOAD",
            textColor = colorResource(id = R.color.background_home),
            colorBackground = colorResource(id = R.color.special_button),
            textSize = 35,
            modifier = Modifier
        )
        CustomEmptyButton(
            title = "FREE",
            textColor = Color.Green,
            colorBackground = colorResource(id = R.color.background_home),
            textSize = 12,
            modifier = Modifier
        )
    }
}
