package com.gcolina.freebies.views.detailView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gcolina.freebies.R
import com.gcolina.freebies.util.ShowImageWhitCoil
import com.gcolina.freebies.viewModel.DetailViewModel

@Composable
fun DetailView(
    navController: NavController,
    detailViewModel: DetailViewModel = hiltViewModel(),
    id: Int
) {
    val gameById by detailViewModel.gameById.collectAsState()

    LaunchedEffect(detailViewModel.firstTime) {
        if (detailViewModel.firstTime.value) {
            detailViewModel.firstTime.value = false
            detailViewModel.getGameById(id)
        }
    }

    gameById?.let { gameById ->
        LazyColumn(
            Modifier
                .background(colorResource(id = R.color.background_home))
        ) {
            item {
                CardDetail(title = gameById.title, description = gameById.description)
            }
            item {
                LazyRow(
                    modifier = Modifier
                ) {
                    items(gameById.screenshots.size) { index ->

                        Box(
                            Modifier
                                .height(200.dp).width(400.dp)
                        ) {
                            ShowImageWhitCoil(image = gameById.screenshots[index].image)
                        }
                    }
                }
            }
        }
    }
}

/*  Box(
        modifier =
        Modifier
            .fillMaxSize()
            .background(Color.Red)
        // .background(colorResource(id = R.color.background_home)),
    ) {
        gameById?.let { character ->
            Column {
                Box(
                    modifier =
                    Modifier.fillMaxWidth().height(200.dp)
                ) {
                    ShowImageWhitCoil(image = character.thumbnail)
                }
                Card(
                    modifier =
                    Modifier
                        .fillMaxSize(),
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),colors = CardDefaults.cardColors(colorResource(id = R.color.background_home))
                ) {
                    // Text(text = character.title, fontWeight = 30.sp)
                }
            }
        }
    }*/

// Como hago para llamar a esta funcion???? y que se inicialize

/*fun getGameById( detailViewModel: DetailViewModel){
    detailViewModel.getGameById(id)
}*/
