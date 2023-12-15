package com.ahmed.woodiewwin.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ahmed.woodiewwin.R
import com.ahmed.woodiewwin.navigation.HomeComponent
import com.ahmed.woodiewwin.ui.theme.DarkBlue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay


@SuppressLint("RememberReturnType")
@Composable
fun SplashScreen(navController: NavHostController, context: Context) {

    val alpha = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        delay(500)
        alpha.animateTo(
            1f,
            animationSpec = tween(
                800,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(2000)

            navController.popBackStack()
            navController.navigate(HomeComponent.route)


    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(contentAlignment = Alignment.Center) {
            LoaderAnimation(
                modifier = Modifier.size(400.dp),
                anim = R.raw.boom_animation
            )

            Icon(
                painter = painterResource(id = R.drawable.logo_app),
                contentDescription ="logo",
                tint = Color.Unspecified,
                modifier = Modifier.size(200.dp)
                    .scale(alpha.value)
                )
        }
    }
}

@Composable
fun LoaderAnimation(modifier: Modifier, anim: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(anim))

    LottieAnimation(
        composition = composition, iterations = 1,
        modifier = modifier
    )
}

private fun onBoardingIsFinished(context: Context): Boolean {
    val sharedPreferences = context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean("isFinished", false)

}