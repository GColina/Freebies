package com.gcolina.freebies.views.homeView

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gcolina.freebies.util.CommonCardAnimation
import com.gcolina.freebies.viewModel.GameViewModel

@Suppress("ktlint:standard:function-naming")
@Composable
fun BodyHome(
    viewModel: GameViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    navController: NavController
) {
    val characters by viewModel.characters.collectAsState()

    LazyColumn(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        items(characters) { characters ->
            CommonCardAnimation(
                title = characters.title,
                imageCard = characters.thumbnail,
                shortDetail = characters.short_description,
                navigateToDetail = { navController.navigate("DetailView/${characters.id}") }
            )
        }
    }
}

/* modifier = Modifier.animateItemPlacement( // Animate item placement
     // Start from bottom
     animationSpec = tween(
         // Customize animation
         durationMillis = 3000, // Adjust duration (ms)
         easing = FastOutSlowInEasing, // Adjust easing for smooth appearance
     )
 )*/
