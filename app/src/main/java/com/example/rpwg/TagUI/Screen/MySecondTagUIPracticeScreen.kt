package com.example.rpwg.TagUI.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable
fun MySecondTagUIPracticeScreen(modifier: Modifier = Modifier) {
    val profileShortcutMenu = listOf<String>("이용권구매", "이벤트", "고객센터", "공지사항")
    val shortcutMenu = listOf<String>(
        "멜론차트",
        "최신음악",
        "DJ말랑이",
        "멜론DJ",
        "장르음악",
        "오늘의숏무직",
        "뮤직웨이브",
        "멜론TV",
        "더미 매뉴",
        "더미 매뉴",
        "더미 매뉴",
        "더미 매뉴"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF111111))
    ) {
        val chipModifier = Modifier
            .weight(1f)
            .padding(4.dp)
            .height(40.dp)
//            .clip(RoundedCornerShape(16.dp))
//            .background(Color.Green)
            .padding(10.dp)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxHeight()
//                        .fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "좋아요",
                        tint = Color(0xFF2a2a2a),
                        modifier = Modifier
                            .size(60.dp, 60.dp)
                    )
                    Text("로그인 해주세요", color = Color.White, fontSize = 16.sp)
                }
                Row(

                ) {
                    Text(
                        "로그인", color = Color.White,
                        modifier = Modifier
                            .border(
                                border = BorderStroke(width = 1.dp, color = Color(0xFFdddddd)),
                                shape = RoundedCornerShape(percent = 50)
                            )
                            .padding(4.dp)

                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color(0xFF02b749))
            ) {
                Text("이용권을 구매해주세요", color = Color.White)
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                profileShortcutMenu.forEach {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = modifier
                            .weight(1f)

                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
//                                .background(Color.Yellow)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "좋아요",
                                tint = Color(0xFF02b749),
                                modifier = Modifier
                            )
                            Text(it, color = Color.White, textAlign = TextAlign.Center)
                        }
                    }
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(
                "감상",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = Bold,
                modifier = Modifier
            )
        }
        FlowRow(
            maxItemsInEachRow = 2,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            shortcutMenu.forEach {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = chipModifier,
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "좋아요",
                        tint = Color(0xFF02b749),
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Text(it, color = Color.White, textAlign = TextAlign.Center)
                }
            }
        }
    }


}