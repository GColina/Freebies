
package com.gcolina.freebies.views.homeView

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.gcolina.freebies.R



@Composable

fun HomeView( navController: NavController) {

    Scaffold (
        containerColor = colorResource(id = R.color.background_home),
        topBar = { TopBarHome() }
    ){

        BodyHome( paddingValues = it , navController = navController)

    }

}

