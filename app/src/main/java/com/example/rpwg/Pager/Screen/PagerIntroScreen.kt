package com.example.rpwg.Pager.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.launch

@Composable
fun PagerIntroScreen(modifier: Modifier = Modifier){


    val items = listOf<String>("사과","딸기","바나나", "수박","참외") // 아이템 리스트
    val pagerState = rememberPagerState(pageCount = { // 페이지 수 // pagerState.currentPage 현재 페이지 가져오는거
        items.count() // 아이템 리스트 수 만큼
    })

//    LaunchedEffect(Unit) {
//        pagerState.animateScrollToPage(3) // 앱 실행시 최초에 열리는 페이지
//    }

    val scope = rememberCoroutineScope()


    Box( // 띄워져 있는 고정된 박스
        modifier = Modifier
            .padding()
            .fillMaxSize()
            .padding(20.dp)
            .padding(top = 30.dp, bottom = 30.dp)
            .zIndex(1f)
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween, // 내부 요소들 세로 정렬
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, // 인사말, 닫기 버튼
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, // 좌측 상단 인사말
                    modifier = Modifier
                        .background(Color.Green)
                ) {
                    Text("안녕하세요 ", fontSize = 40.sp)
                    Text("${pagerState.currentPage + 1}", fontSize = 40.sp) // 현재 위치
                }
                Button(onClick = {}) { // 상단 우측 닫기 버튼
                    Text("닫기")
                }
            }
            Box(contentAlignment = Alignment.Center, // 컨텐츠 하단 현재 페이지 / 전체 페이지
                modifier = Modifier
                    .padding(top = 420.dp, end = 22.dp)
                    .background(Color.Red)
                    .width(130.dp)
                    .height(60.dp)
                    .align(alignment = Alignment.End)
            ) {
                Text("${pagerState.currentPage + 1} / ${items.count()}", color = Color.White) // 현재 페이지 위치 / 전체 페이지
            }
            Box(

            ) {
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .background(Color.Magenta)
                        .align(alignment = Alignment.Center)
                        .clickable(onClick = {
                            scope.launch {
                                val currentPage = pagerState.currentPage // 페이지 수 담기
                                pagerState.animateScrollToPage(currentPage + 1) // 페이지 수에 1 더해서 다음 넘어가기
                            }
                        })
                ){
                    if (pagerState.currentPage < items.count() - 1) {
                        Text("다음")
                    } else {
                        Text("시작하기")
                    }
                }
            }
        }
    }
    HorizontalPager(pagerState, // 아이템 리스트 수 만큼 페이지 만든다
        modifier = modifier
            .fillMaxSize()
    ) { currentPage ->
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxSize()
//                    .background(Color.random()) // 배경 색 랜덤
        ) {
            Box(modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
//                .size(width = 300.dp, height = 400.dp)
            )



//            Button(onClick = {
//                scope.launch {
//                    val currentPage = pagerState.currentPage // 페이지 수 담기
//                    pagerState.animateScrollToPage(currentPage + 1) // 페이지 수에 1 더해서 다음 넘어가기
//                }
//            }) {
//                Text("다음")
//            }
        }
    }

}
