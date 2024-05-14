package com.gcolina.freebies.views.homeView

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.gcolina.freebies.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarHome(onTextValueChanged: (String) -> Unit) {
    var textValue by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 3.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { }) {
            Image(
                painter = painterResource(id = R.drawable.btn_menu),
                contentDescription = null
            )
        }

        OutlinedTextField(
            value = textValue,
            onValueChange = { newValue ->
                textValue = newValue
                onTextValueChanged(newValue)
            },
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            textStyle = TextStyle(color = colorResource(id = R.color.background_home)),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                disabledLabelColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically),

            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null
                )
            }
        )
    }
}
