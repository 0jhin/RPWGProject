package com.example.rpwg.TagUI.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
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
fun MyTagUIPracticeScreen(modifier: Modifier = Modifier) {
    val shortcutMenu =
        listOf<String>("AI채팅", "커뮤니티", "요즘코디", "AI프로필", "웹툰/웹소설", "매거진", "운세", "AI옷입기")

    Column(
        modifier = modifier
//            .fillMaxWidth()
            .fillMaxSize()
    ) {
        val chipModifier = Modifier
            .weight(1f)
            .padding(4.dp)
            .height(40.dp)
//            .clip(RoundedCornerShape(16.dp))
//            .background(Color.Green)
            .padding(10.dp)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(
                "바로가기",
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
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = chipModifier,
                ) {
                    Text(it, textAlign = TextAlign.Center)
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "좋아요",
                        tint = Color(0xFF000000),
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }
        }
    }


}