package com.example.rpwg.CustomPopup.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex


@Preview(showBackground = true)
@Composable
fun CustomPopupScreen(modifier: Modifier = Modifier){

    var selectedItem by remember { mutableStateOf<String?>(null) } // 선택한 아이템 담을 목록

    val isEnabled = selectedItem == null

    val items : List<String> = (0..99).map { "아이디 : $it" } // 0 ~ 99까지 더미 데이터 생성
    Box(modifier = modifier.fillMaxSize()
    ) { // 기본 틀 박스
        // 팝업
        if(selectedItem != null){ // selectItem에 값이 있다면
            Box( // 투명한 팝업 배경
                modifier = Modifier.fillMaxSize() // 화면 전체를 덮도록
                    .background(Color.Black.copy(0.7f)) // 약간 투명하게
                    .clickable(interactionSource = null, // 배경 터치해도 팝업 닫히도록 // interactionSource 찾아보기
                        indication = null, // indication 찾아보기
                        onClick = {
                            selectedItem = null // selectItem을 비워서 조건 탈출
                        })
                    .zIndex(2f) // 위로 띄우고
            ){
                Column( // 팝업 창
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                        .background(Color.White)
                        .fillMaxWidth(1f)
                        .align(Alignment.BottomCenter)
                        .padding(20.dp)
                ) {
                    Text("제목입니다 : $selectedItem")
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            selectedItem = null
                        }) {
                        Text("닫기")
                    }
                }
            }
        }

        // 아이템 목록
        Column(
            verticalArrangement = Arrangement
                .spacedBy(10.dp),
            modifier = Modifier.matchParentSize()
                .verticalScroll(rememberScrollState())
                .padding(10.dp)
        ) {
            items.forEach { currentItem ->
                Text("아이템 : $currentItem",
                    modifier = Modifier
                        .background(Color.Yellow)
                        .clickable(enabled = isEnabled,
                            onClick = {
                                selectedItem = currentItem
                            })
                        .padding(20.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}