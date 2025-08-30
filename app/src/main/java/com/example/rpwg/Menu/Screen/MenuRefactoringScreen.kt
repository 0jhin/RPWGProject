package com.example.rpwg.Menu.Screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MenuRefactoringScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        val menuList = listOf<String>("탕수육", "짬뽕", "짜장면")
        val selectedMenus = remember { mutableStateListOf<String>() }
        val selectMenuCount = remember { mutableIntStateOf(0) }
        fun handleSelection(menu: String) { // 반복되는 것 함수로 빼기
            if (selectedMenus.contains(menu)) {
                Log.d("[클릭]", "onCreate: 빼기")
                selectedMenus.remove(menu)
            } else {
                Log.d("[클릭]", "onCreate: 넣어주기")
                selectedMenus.add(menu)
            }
        }

        val getSelectionColor: (menu: String) -> Color = { // 반복되는 것 함수로 빼기
            if (selectedMenus.contains(it)) {
                Color.Green
            } else {
                Color.LightGray
            }
        }

        fun selectMenuCount(menuNum: Int) { // 선택된 매뉴 카운트
//                            val selectMenuCount = selectedMenus.indexOf()
        }

        Column(
            modifier = Modifier
                .padding()
        ) {

            val selectedMenusInfo = selectedMenus.joinToString(separator = " - ")

            Text("선택된 메뉴들: $selectedMenusInfo")
            val selectMenuCount = selectMenuCount

            Row()
            {

                menuList.forEach { aMenu ->
                    Text(
                        aMenu, modifier = Modifier
                            .background(getSelectionColor(aMenu))
                            .padding(20.dp)
                            .clickable(onClick = {
                                Log.d("[클릭]", "onCreate: ")
                                handleSelection(aMenu)
                            })
                    )
                }
            }
        }
    }
}
