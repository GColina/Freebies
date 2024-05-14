package com.gcolina.freebies.views.homeView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gcolina.freebies.R
import com.gcolina.freebies.util.CommonCardAnimation
import com.gcolina.freebies.util.CustomButton
import com.gcolina.freebies.viewModel.GameViewModel

@Composable
fun BodyHome(
    viewModel: GameViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    navController: NavController
) {
    val characters by viewModel.characters.collectAsState()
    var query by remember { mutableStateOf("") }

    LaunchedEffect(viewModel.firstTime) {
        if (viewModel.firstTime.value) {
            viewModel.firstTime.value = false
            viewModel.getCharacters()
        }
    }

    Column {
        TopBarHome(
            onTextValueChanged = { newQuery ->
                query = newQuery
            }
        )

        LazyColumn(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) {
            items(characters) { characters ->
                if (query.isNotEmpty()) {
                    val filterGame = characters.title.filter {
                        characters.title.contains(
                            query,
                            ignoreCase = true
                        )
                    }
                    val filteredCharacter = filterGame.firstOrNull()
                    if (filteredCharacter != null) {
                        Column(Modifier.fillMaxWidth()) {
                            CommonCardAnimation(
                                title = characters.title,
                                imageCard = characters.thumbnail,
                                shortDetail = characters.short_description,
                                navigateToDetail = {
                                    navController.navigate(
                                        "DetailView/${characters.id}"
                                    )
                                }
                            )
                        }
                    }
                } else {
                    CommonCardAnimation(
                        title = characters.title,
                        imageCard = characters.thumbnail,
                        shortDetail = characters.short_description,
                        navigateToDetail = { navController.navigate("DetailView/${characters.id}") }
                    )
                }
                CustomButton(
                    title = "GO TO DETAIL",
                    textColor = colorResource(id = R.color.background_home),
                    colorBackground = colorResource(id = R.color.special_button),
                    textSize = 32,
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp, top = 10.dp),
                    onClick = {
                        navController.navigate(
                            "DetailView/${characters.id}"
                        )
                    }
                )
            }
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

/*Column {
//

        TopBarHome(
            onTextValueChanged = { newQuery ->
                query = newQuery
            }
        )


        LazyColumn(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) {
            items(characters) { characters ->

                if (query.isNotEmpty()) {
                    val filterGame = characters.title.filter {
                        characters.title.contains(
                            query,
                            ignoreCase = true
                        )
                    }
                    filterGame.forEach {
                        CommonCardAnimation(
                            title = characters.title,
                            imageCard = characters.thumbnail,
                            shortDetail = characters.short_description,
                            navigateToDetail = {
                                navController.navigate(
                                    "DetailView/${characters.id}"
                                )
                            }
                        )
                    }
                } else {
                    CommonCardAnimation(
                        title = characters.title,
                        imageCard = characters.thumbnail,
                        shortDetail = characters.short_description,
                        navigateToDetail = { navController.navigate("DetailView/${characters.id}") }
                    )
                }
            }
        }
    }*/
