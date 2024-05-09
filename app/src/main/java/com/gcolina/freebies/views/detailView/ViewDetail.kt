package com.gcolina.freebies.views.detailView

import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gcolina.freebies.R
import com.gcolina.freebies.util.CustomButton
import com.gcolina.freebies.util.CustomEmptyButton
import com.gcolina.freebies.viewModel.DetailViewModel

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ViewDetail(viewModel: DetailViewModel = hiltViewModel()) {
    val characters by viewModel.gameById.collectAsState()

    Column(
        modifier =
        Modifier
            .fillMaxSize()
    ) {
        characters?.let { characters ->
        }
    }
}

@Composable
fun CardDetail(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(enabled = true, state = rememberScrollState()),
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        colors = CardDefaults.cardColors(colorResource(id = R.color.background_home))
    ) {
        Column(modifier = Modifier.padding(30.dp)) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 34.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = description,
                color = Color.White,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = SpaceBetween) {
                Column(modifier = Modifier.weight(0.4f)) {
                    CustomEmptyButton(
                        title = "FREE",
                        textColor = Color.Green,
                        colorBackground = colorResource(id = R.color.background_home),
                        textSize = 12,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    CustomButton(
                        title = "ACTIVE",
                        textColor = colorResource(id = R.color.background_home),
                        colorBackground = Color.Green,
                        textSize = 12,
                        modifier = Modifier
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                CustomButton(
                    title = "DOWNLOAD",
                    textColor = colorResource(id = R.color.background_home),
                    colorBackground = colorResource(id = R.color.special_button),
                    textSize = 35,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
