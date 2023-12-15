package com.ahmed.woodiewwin.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.woodiewwin.ui.theme.Green

@Composable
fun MegaCard() {
    Card(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Green)
    ) {
        Text(
            text = "MEGA",
            color = Color.White,
            fontSize = 9.sp,
            modifier = Modifier.background(Green)
                .padding(3.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MegaCardPreview() {
    MegaCard()
}