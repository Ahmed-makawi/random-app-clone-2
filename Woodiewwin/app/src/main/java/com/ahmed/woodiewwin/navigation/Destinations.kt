package com.ahmed.woodiewwin.navigation

interface Destinations {
    val route:String
}

object SplashScreen: Destinations{
    override val route = "SplashScreen"
}

object HomeComponent: Destinations{
    override val route = "HomeComponent"
}