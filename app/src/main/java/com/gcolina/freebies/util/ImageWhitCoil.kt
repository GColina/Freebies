package com.gcolina.freebies.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalCoilApi::class)
@Composable
fun ShowImageWhitCoil(image: String) {
    val imagePainter = rememberImagePainter(data = image)

    val state = imagePainter.state
    if (state is ImagePainter.State.Loading) {
        LoadingAnimation()
    }

    Image(
        painter = imagePainter,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
    )
}
