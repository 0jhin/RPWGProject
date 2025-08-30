package com.example.rpwg.MarketKurly.Screen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.twotone.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MarketKurlyScreen(modifier: Modifier = Modifier) {
    val addTagList = remember { mutableStateListOf<String>() }
    var text by remember { mutableStateOf("") }
    val recommendedSearch =
        listOf<String>("크림치즈", "유부초밥", "반숙란", "저속노화", "갈비탕", "땅콩 버터", "그릭요거트", "마감세일")
    val rapidSearch =
        listOf<String>("슬라이스햄", "파예", "애슐리", "떡볶이떡", "백숙", "연어장", "회", "느타리", "치킨텐더", "돈까스소스")
    Column( // 기본 틀
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically // 최상단 가로줄(뒤로가기, 검색창)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, // 뒤로가기 아이콘
                contentDescription = "뒤로가기", // 설명
                modifier = Modifier
                    .size(56.dp)
                    .clickable(onClick = {
                        Log.d(
                            "클릭됨",
                            "클릭됨"
                        )
                    }) // 클릭 가능하도록 TODO: (여기에 검색어 지우는 기능 넣을지)
            )
            Box { // 검색창 박스
                TextField( // 검색창
                    value = text, // 담을 내용
                    onValueChange = { newText -> text = newText }, // TODO: 이거 뭘까?
                    trailingIcon = { // 동작 아이콘
                        if (text.isNotEmpty()) { // text가 내용이 있으면
                            Button(
                                onClick = { // 클릭하면
                                    addTagList.add(text) // text를 addTagList에 추가
                                    text = "" // 검생창 초기화
                                    Log.d("add", "add")
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Black
                                ), // 아이콘 색
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(50), // 아이콘 둥글게
                                modifier = Modifier
                            ) { Text("검색") } // 버튼 안에 내용
                        }
                    },
                    placeholder = { Text("검색어를 입력하세요") },
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("최근 검색어")
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "더보기",
                modifier = Modifier
                    .size(52.dp)
                    .clickable(
                        indication = null, // Disable the ripple effect
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        Log.d("클릭됨", "클릭됨")
                    },
            )
        }
        FlowRow( // 최근 검색어 저장
            modifier = Modifier
                .fillMaxWidth() // 가로 최대
                .horizontalScroll(state = rememberScrollState()) // 가로 스크롤
        ) {
            addTagList.forEach {
                it
                TagButton(it, onClick = {
                    addTagList.remove(it)
                })
            }
        }
        val chipModifier = Modifier
            .padding(4.dp)
            .height(40.dp)
            .clip(androidx.compose.foundation.shape.RoundedCornerShape(16.dp))
            .clickable(onClick = { Log.d("클릭됨", "클릭됨") })
            .background(Color(0xFFf7edff))
            .padding(10.dp)


        FlowRow(
            maxLines = 2,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            recommendedSearch.forEach {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = chipModifier,
                ) {
                    Text(it, color = Color(0xFF8e58c3), textAlign = TextAlign.Center)
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()

        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
//                                    .weight(1f)
                ) {
                    Text("급상승 검색어")
                    Icon(
                        imageVector = Icons.TwoTone.Info,
                        contentDescription = "정보"
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
//                                    .weight(1f)
                ) {
                    Text("최근 1시간 동안 검색 횟수가 급상승했어요", color = Color(0xFF8c8d95))
                }
            }
            FlowRow(
                maxItemsInEachRow = 2,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                val rapidSearchChip = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .height(40.dp)
                    .clickable(onClick = { Log.d("클릭됨", "클릭됨") })
                    .background(Color(0xFFffffff))
                    .padding(10.dp)
                rapidSearch.forEachIndexed { index, string ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = rapidSearchChip,
                    ) {
                        Text(
                            "${index + 1} $string",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun SearchTag(modifier: Modifier = Modifier) {
    var addTagList = remember { mutableStateListOf<String>() }
    var text by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Box(
        ) {
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                trailingIcon = {
                    if (text.isNotEmpty()) {
                        Button(
                            onClick = {
                                addTagList.add(text)
                                text = ""
                                Log.d("add", "add")
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = Color.Black
                            ),
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(50),
                            modifier = Modifier
                                .align(alignment = Alignment.CenterEnd)
                        )

                        { Text("검색") }
                    }
                },
                placeholder = { Text("검색어를 입력하세요") },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        FlowRow(
            modifier = modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {

            addTagList.forEach { it ->
                it
                Button(onClick = {
                    Log.d("test", "test")
                    val deleteTag = addTagList.map { it }.toMutableList()

                    deleteTag.remove(it)

                    addTagList = deleteTag.toMutableStateList()
                }) {
                    Text(it)
                }
            }
        }
    }
}


@Composable
fun TagButton(title: String, onClick: () -> Unit) {
    Text(
        title, modifier = Modifier
            .clickable(onClick = { //onClick
                Log.d("dd", "")
                onClick.invoke()
            })
            .padding(8.dp)
            .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(50))
            .background(Color.White)
            .border(
                border = BorderStroke(width = 2.dp, color = Color(0xFF000000)),
                shape = RoundedCornerShape(percent = 50)
            )
            .padding(12.dp)

    )
}