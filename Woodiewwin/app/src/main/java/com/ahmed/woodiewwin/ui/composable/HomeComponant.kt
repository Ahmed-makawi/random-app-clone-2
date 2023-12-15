package com.ahmed.woodiewwin.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ahmed.woodiewwin.ui.screens.AccountScreen
import com.ahmed.woodiewwin.ui.screens.HomeScreen
import com.ahmed.woodiewwin.ui.screens.MoreScreen
import com.ahmed.woodiewwin.ui.screens.MyContestScreen


@Composable
fun HomeComponent() {
    val bottomScreen = remember { mutableStateOf(BottomNav.Home) }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (bottomScreen.value) {
                BottomNav.Home -> HomeScreen(bottomScreen = bottomScreen)
                BottomNav.MyContest -> MyContestScreen (bottomScreen = bottomScreen)
                BottomNav.Account -> AccountScreen(bottomScreen = bottomScreen)
                BottomNav.More -> MoreScreen(bottomScreen = bottomScreen)
            }
        }
    }
}
