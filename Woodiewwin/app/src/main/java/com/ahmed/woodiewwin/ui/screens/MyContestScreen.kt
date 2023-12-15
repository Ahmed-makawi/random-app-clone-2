package com.ahmed.woodiewwin.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.ahmed.woodiewwin.ui.composable.AppBar
import com.ahmed.woodiewwin.ui.composable.BottomAppBar
import com.ahmed.woodiewwin.ui.composable.BottomNav
import com.ahmed.woodiewwin.ui.theme.BackgroundWhite

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyContestScreen(bottomScreen: MutableState<BottomNav>) {
    Scaffold(
        bottomBar = { BottomAppBar(screen = bottomScreen) }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(BackgroundWhite)
        ) {
            AppBar()
            Text(text = "MY CONTEST SCREEN",
                fontSize = 30.sp,
                color = Color.Black
            )
        }
    }
}