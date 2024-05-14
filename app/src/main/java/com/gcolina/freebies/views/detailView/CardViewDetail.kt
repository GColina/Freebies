package com.gcolina.freebies.views.detailView

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gcolina.freebies.R
import com.gcolina.freebies.util.CustomButton
import com.gcolina.freebies.util.CustomEmptyButton

@Composable
fun CardDetail(title: String, description: String, modifier: Modifier, url: String) {
    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        colors = CardDefaults.cardColors(colorResource(id = R.color.background_home))
    ) {
        Column(modifier = Modifier.padding(30.dp)) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 34.sp,
                fontFamily = FontFamily(Font(R.font.josefinsans_semibold)),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = description,
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.josefinsans_semibold)),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(30.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(0.6f)) {
                    CustomEmptyButton(
                        title = "FREE",
                        textColor = Color.Green,
                        colorBackground = Color.Transparent,
                        textSize = 12,
                        modifier = Modifier
                    )

                    Spacer(modifier = Modifier.weight(0.2f))
                    CustomButton(
                        title = "ACTIVE",
                        textColor = colorResource(id = R.color.background_home),
                        colorBackground = Color.Green,
                        textSize = 12,
                        modifier = Modifier
                    )
                }
                // Spacer(modifier = Modifier.weight(0.1f))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    CustomButton(
                        title = "DOWNLOAD",
                        textColor = colorResource(id = R.color.background_home),
                        colorBackground = colorResource(id = R.color.special_button),
                        textSize = 30,
                        modifier = Modifier,
                        onClick = {
                            context.startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}
