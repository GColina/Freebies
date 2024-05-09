package com.gcolina.freebies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gcolina.freebies.views.detailView.DetailView
import com.gcolina.freebies.views.homeView.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeView") {
        composable("HomeView") {
            HomeView(navController)
        }
        composable(
            "DetailView/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            val getId = it.arguments?.getInt("id") ?: 0
            DetailView(navController = navController, id = getId)
        }
    }
}
