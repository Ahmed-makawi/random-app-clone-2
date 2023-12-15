package com.ahmed.woodiewwin.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.woodiewwin.R
import com.ahmed.woodiewwin.data.DummyData
import com.ahmed.woodiewwin.data.dummyList
import com.ahmed.woodiewwin.ui.composable.AppBar
import com.ahmed.woodiewwin.ui.composable.BottomAppBar
import com.ahmed.woodiewwin.ui.composable.BottomNav
import com.ahmed.woodiewwin.ui.composable.MegaCard
import com.ahmed.woodiewwin.ui.theme.BackgroundWhite
import com.ahmed.woodiewwin.ui.theme.Green
import com.ahmed.woodiewwin.ui.theme.Red

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(bottomScreen: MutableState<BottomNav>) {

    Scaffold(
        bottomBar = { BottomAppBar(screen = bottomScreen) }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(BackgroundWhite)
        ) {
            AppBar()

            Spacer(modifier = Modifier.height(10.dp))
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clip(RoundedCornerShape(5.dp))
                        .background(Red)
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "BANNER HERE",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(15.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn {
                    items(dummyList) { dummyData ->
                        cardItem(dummyData)
                    }
                }

            }
        }
    }
}

@Composable
fun cardItem(item: DummyData) {
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .shadow(5.dp, RoundedCornerShape(10.dp)),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {

                Text(text = item.contestName, color = Color.Black.copy(0.6f), fontSize = 12.sp)

                if (item.lineups) {
                    Text(text = "🔴 Lineups Out", color = Red, fontSize = 11.sp)
                } else {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_add_reminder),
                            contentDescription = null,
                            modifier = Modifier.size(23.dp)
                                .clickable {  },
                            tint = Color.Unspecified
                        )
                }
            }

            Divider(thickness = 0.7.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, top = 15.dp, end = 15.dp)
            ) {
                Column {
                    Text(text = item.teamOneName, color = Color.Black, fontSize = 13.sp)
                    Spacer(modifier = Modifier.height(5.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = item.teamOneIcon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.size(45.dp)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = item.teamOneNickname, color = Color.Black, fontSize = 13.sp)
                    }
                }

                Text(text = item.time, color = Red, fontSize = 13.sp)

                Column(horizontalAlignment = Alignment.End) {
                    Text(text = item.teamTwoName, color = Color.Black, fontSize = 13.sp)
                    Spacer(modifier = Modifier.height(5.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = item.teamTowNickname, color = Color.Black, fontSize = 13.sp)
                        Spacer(modifier = Modifier.height(5.dp))
                        Icon(
                            painter = painterResource(id = item.teamTwoIcon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.size(45.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .background(BackgroundWhite)
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                MegaCard()
                Spacer(modifier = Modifier.width(7.dp))
                Text(text = item.rupees, color = Green, fontSize = 13.sp)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun cardItemPreview(
    item: DummyData = DummyData(
        teamOneName = "England",
        teamOneNickname = "ENG",
        teamTwoName = "India",
        teamTowNickname = "IND",
        teamOneIcon = R.drawable.icon_england,
        teamTwoIcon = R.drawable.icon_india,
        contestName = "T20 World Cup",
        rupees = "₹25 Crores",
        time = "25m 30s",
        lineups = false
    )
) {
    cardItem(item)
}