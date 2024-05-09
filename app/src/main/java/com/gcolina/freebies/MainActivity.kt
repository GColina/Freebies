package com.gcolina.freebies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.gcolina.freebies.navigation.NavManager
import com.gcolina.freebies.ui.theme.FreebiesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    /*
    Esto solo lo llamo para cuando necesite modificarlos
    private val gameViewModel: GameViewModel by viewModels()
    private val detailViewModel: DetailViewModel by viewModels()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreebiesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    NavManager()
                }
            }
        }
    }
}
