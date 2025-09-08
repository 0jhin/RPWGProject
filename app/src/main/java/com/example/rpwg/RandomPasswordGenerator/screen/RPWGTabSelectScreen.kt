package com.example.rpwg.RandomPasswordGenerator.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.rpwg.RandomPasswordGenerator.components.TabComponent


@Composable
fun RPWGTabSelectScreen(modifier: Modifier = Modifier) {
    val tabMenu = listOf<String>("비밀번호 생성", "저장된 비밀번호")

    var selectedTab = remember { mutableStateOf("비밀번호 생성") } // 기본은 비밀번호 생성 화면

    Column(verticalArrangement = Arrangement.Top, // 백그라운드 화면
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp)
    ) { // 백그라운드 화면
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp, alignment = Alignment.CenterHorizontally), // 상단 화면 선택 탭
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) { // 상단 화면 선택 탭
            tabMenu.forEach { it // 매뉴만큼 반복해서 버튼 생성
                TabComponent(title = it, // 버튼
                    color = if (selectedTab.value == it) Color.LightGray else Color.Transparent, // 배경 색 없애고 선택 되면 색 채움
                    modifier = Modifier
                        .weight(1f, fill = false)
                        .border(shape = RoundedCornerShape(50), border = BorderStroke(1.dp, Color.LightGray)), // 테두리로 버튼 보이게
                    onClick = { // onClick
                        selectedTab.value = it // 눌리면 변수에 자기 자신을 넣는다
                    } // onClick
                ) // 버튼
            } // 매뉴만큼 반복해서 버튼 생성
        } // 상단 화면 선택 탭
        if (selectedTab.value == "비밀번호 생성") {
            RPWGScreen() // 비밀번호 생성
        }
        else {
            SavedPasswordScreen() // 저장된 비밀번호 확인
        }
    } // 백그라운드 화면
}



