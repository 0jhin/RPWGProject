package com.example.rpwg.Kihya.Screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.rpwg.Kihya.Component.ButtonType
import com.example.rpwg.Kihya.Component.CartList
import com.example.rpwg.Kihya.Component.CategoriesList
import com.example.rpwg.Kihya.Component.FooterMemuBar
import com.example.rpwg.Kihya.Component.KihyaHeader
import com.example.rpwg.Kihya.Component.MyMap
import com.example.rpwg.Kihya.Component.ProductsMain
import com.example.rpwg.Kihya.Component.ShoppingCartTop
import com.example.rpwg.layout.MainLayout

@Composable
fun KihyaScreen() {
    val selectIndex = remember { mutableStateOf(0) }
    MainLayout(
        header = {
            KihyaHeader(onClick = {
                when (it) {
                    ButtonType.CART -> {
                        selectIndex.value = 1
                    }

                    ButtonType.MAP -> {
                        selectIndex.value = 2
                    }
                }
            })
        },
        content = {
            when (selectIndex.value) {
                0 -> {
                    CategoriesList()
                    ProductsMain(
                        "😍 고객님의 취향에 맞춘 추천",
                        "AI가 고객님의 취향에 딱 맞는 친구들을 찾아왔어요!"
                    )
                    ProductsMain("🥳 새로운 신상품을 소개해요!", "키햐 신상품들을 특별한 가격에 만나보세요!")
                }

                1 -> {
                    ShoppingCartTop()
                    CartList()
                    ProductsMain("👍픽업은 기왕이면 한번에!?", "함계 주문하면 딱 좋은 친구들을 AI가 찾아왔어요!")
                }

                2 -> {
                    MyMap()
                }
            }
        },
        footer = {
            FooterMemuBar(
                homeClick = { selectIndex.value = 0 },
                menuClick = { Log.d("버튼 매뉴", "매뉴") },
                searchClick = { Log.d("버튼 검색", "검색") },
                checkClick = { Log.d("버튼 체크", "체크") },
                personClick = { Log.d("버튼 사람", "사람") }
            )
        },
        modifier = Modifier
    )
}