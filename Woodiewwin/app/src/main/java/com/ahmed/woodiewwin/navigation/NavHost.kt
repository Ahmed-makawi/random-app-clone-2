package com.ahmed.woodiewwin.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmed.woodiewwin.ui.composable.HomeComponent
import com.ahmed.woodiewwin.ui.screens.SplashScreen
import com.ahmed.woodiewwin.ui.screens.HomeScreen

@Composable
fun Navhost(context: Context) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SplashScreen.route) {
        composable(SplashScreen.route) {
            SplashScreen(navController = navController, context = context)
        }
        composable(HomeComponent.route) {
            HomeComponent()
        }
    }
}