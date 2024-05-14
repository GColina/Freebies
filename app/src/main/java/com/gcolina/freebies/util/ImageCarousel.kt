package com.gcolina.freebies.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gcolina.freebies.model.gameModelById.Screenshot

@Composable
fun ImageCarousel(screenshots: List<Screenshot>) {
    LazyRow {
        items(screenshots.size) { index ->
            Box(
                Modifier
                    .height(200.dp)
                    .width(400.dp)
            ) {
                ShowImageWhitCoil(image = screenshots[index].image)
            }
        }
    }
}
