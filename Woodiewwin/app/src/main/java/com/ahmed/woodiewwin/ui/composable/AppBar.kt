package com.ahmed.woodiewwin.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmed.woodiewwin.R
import com.ahmed.woodiewwin.ui.theme.Red

@Composable
fun AppBar() {
    Column(
        modifier = Modifier
            .background(Red)
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(Red)
                .fillMaxWidth()
                .padding(start = 15.dp)
                .height(100.dp)
        ) {

            Row {
                Image(
                    painter = painterResource(id = R.drawable.logo_app),
                    contentDescription = null,
                    modifier = Modifier.size(130.dp)
                )
            }
            Row {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_wallet_filled),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(27.dp)
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_notification_unread),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    AppBar()
}