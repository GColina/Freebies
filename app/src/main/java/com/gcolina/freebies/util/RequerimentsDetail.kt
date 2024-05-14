package com.gcolina.freebies.util

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RequirementText(text: String?) {
    Text(
        text = text ?: "No information available",
        color = Color.White,
        modifier = Modifier.padding(vertical = 5.dp)
    )
}
