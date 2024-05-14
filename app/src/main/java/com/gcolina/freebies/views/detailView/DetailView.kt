package com.gcolina.freebies.views.detailView

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gcolina.freebies.R
import com.gcolina.freebies.util.CustomButton
import com.gcolina.freebies.util.ImageCarousel
import com.gcolina.freebies.util.RequirementText
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
        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.background_home))
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                ShowImageWhitCoil(image = gameById.thumbnail)
                Icon(
                    painter = painterResource(id = R.drawable.back_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            navController.popBackStack()
                        }
                        .padding(20.dp),
                    tint = Color.White
                )
            }

            Column(modifier = Modifier.offset(y = (-20).dp)) {
//
                CardDetail(
                    title = gameById.title,
                    description = gameById.description,
                    modifier = Modifier,
                    url = gameById.gameUrl
                )

                ImageCarousel(screenshots = gameById.screenshots)

                Column(modifier = Modifier.padding(30.dp)) {
                    CustomButton(
                        title = "MINIMUM SYSTEM REQUIREMENTS",
                        textColor = colorResource(id = R.color.background_home),
                        colorBackground = Color.White,
                        textSize = 15,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    let {
                        RequirementText(text = "OS: ${gameById.minimumSystemRequirements?.os}")
                        RequirementText(
                            text = "PROCESSOR: ${gameById.minimumSystemRequirements?.processor}"
                        )
                        RequirementText(
                            text = "MEMORY: ${gameById.minimumSystemRequirements?.memory}"
                        )
                        RequirementText(
                            text = "GRAPHICS: ${gameById.minimumSystemRequirements?.graphics}"
                        )
                        RequirementText(
                            text = "STORAGE: ${gameById.minimumSystemRequirements?.storage}"
                        )
                    }
                }
                Column(
                    modifier = Modifier.padding(start = 30.dp, end = 30.dp, bottom = 30.dp)
                ) {
                    CustomButton(
                        title = "ADITIONAL INFORMATION",
                        textColor = colorResource(id = R.color.background_home),
                        colorBackground = Color.White,
                        textSize = 15,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    RequirementText(text = "DEVELOPER: ${gameById.developer}")
                    RequirementText(text = "PUBLISHER: ${gameById.publisher}")
                    RequirementText(text = "RELEASE DATE: ${gameById.releaseDate}")
                    RequirementText(text = "PLATFORM: ${gameById.platform}")
                }
            }
        }
    }
}

// Como hago para llamar a esta funcion???? y que se inicialize

/*fun getGameById( detailViewModel: DetailViewModel){
    detailViewModel.getGameById(id)
}*/
