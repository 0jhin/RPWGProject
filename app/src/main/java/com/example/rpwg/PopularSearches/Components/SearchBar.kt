package com.example.rpwg.PopularSearches.Components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }
    var addSearchList = remember { mutableStateListOf("") }
    val interactionSource = remember { MutableInteractionSource() } // 리플 지우기

    Row(

    ) {
        TextField( // 검색창
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = CircleShape),
            value= text, // 담을 내용
            onValueChange = { newText -> text = newText }, // TODO: 이거 뭘까?
            trailingIcon = { // 동작 아이콘
                Box(contentAlignment = Alignment.Center, modifier = Modifier.size(40.dp)) {
                    Icon(imageVector = Icons.Default.Search,
                        tint = Color.Black,
                        contentDescription = "검색",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null // 리플 지우기
                            ) {
                                if (text.isNotEmpty()) { // text가 내용이 있으면
                                    addSearchList.add(text) // text를 addTagList에 추가
                                    text = "" // 검생창 초기화
                                    Log.d("클릭됨", "검색")
                                }
                            }
                    )
                }
            },
            placeholder = { Text(text = "대충 광고하는 내용", color = Color.Black.copy(0.5f), fontSize = 12.sp) },
        )
    }
}