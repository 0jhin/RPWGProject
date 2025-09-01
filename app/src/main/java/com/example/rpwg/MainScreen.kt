package com.example.rpwg

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rpwg.Counter.Screen.CounterScreen
import com.example.rpwg.CustomPopup.Screen.CustomPopupScreen
import com.example.rpwg.Kihya.Component.ButtonType
import com.example.rpwg.Kihya.Component.CartList
import com.example.rpwg.Kihya.Component.CategoriesList
import com.example.rpwg.Kihya.Component.FooterMemuBar
import com.example.rpwg.Kihya.Component.KihyaHeader
import com.example.rpwg.Kihya.Component.MyMap
import com.example.rpwg.Kihya.Component.ProductsMain
import com.example.rpwg.Kihya.Component.ShoppingCartTop
import com.example.rpwg.Kihya.Screen.KihyaScreen
import com.example.rpwg.MarketKurly.Screen.MarketKurlyScreen
import com.example.rpwg.Menu.Screen.MenuRefactoringScreen
import com.example.rpwg.OliveYoung.Screen.OliveYoungScreen
import com.example.rpwg.Pager.Screen.PagerIntroScreen
import com.example.rpwg.RandomPasswordGenerator.screen.RPWGScreen
import com.example.rpwg.RandomPasswordGenerator.screen.SavedPasswordScreen
import com.example.rpwg.TagUI.Screen.MySecondTagUIPracticeScreen
import com.example.rpwg.TagUI.Screen.MyTagUIPracticeScreen
import com.example.rpwg.layout.MainLayout
import com.example.rpwg.layout.TestBody
import com.example.rpwg.layout.TestFooter
import com.example.rpwg.layout.TestHeader
import com.example.rpwg.layout.TestLayout
import kotlinx.coroutines.launch


// 탭 막대기 있는 페이저
@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val items = listOf<String>("올리브영", "비밀번호 확인", "비밀번호", "팝업", "바로가기", "온보딩", "멜론", "컬리", "매뉴", "레이아웃", "쇼핑몰", "카운터")

    val pagerState = rememberPagerState(pageCount = { items.count() })

    val scope = rememberCoroutineScope()

    var clickedIndex by remember { mutableStateOf<Int>(0) }

    LaunchedEffect(clickedIndex) {
        pagerState.animateScrollToPage(clickedIndex)
    }

    Column(modifier.fillMaxSize()) {

        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            edgePadding = 0.dp
        ) {

            items.forEachIndexed { index, tabItem ->
                Tab(
                    selected = index == pagerState.currentPage, text = {
                        Text(text = tabItem)
                    },
                    onClick = {
                        clickedIndex = index
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(pagerState) { index ->

            val selectedItem = items[index]

            when (selectedItem) {
                "올리브영" -> {
                    OliveYoungScreen()
                }
                "비밀번호 확인" -> {
                    SavedPasswordScreen()
                }
                "비밀번호" -> {
                    RPWGScreen()
                }
                "팝업" -> {
                    CustomPopupScreen()
                }

                "바로가기" -> {
                    MyTagUIPracticeScreen()
                }

                "온보딩" -> {
                    PagerIntroScreen()
                }

                "멜론" -> {
                    MySecondTagUIPracticeScreen()
                }

                "컬리" -> {
                    MarketKurlyScreen()
                }

                "매뉴" -> {
                    MenuRefactoringScreen()
                }

                "레이아웃" -> {
                    TestLayout(
                        header = { TestHeader() },
                        body = { TestBody() },
                        footer = { TestFooter() }
                    )
                }

                "쇼핑몰" -> {
                    KihyaScreen()
                }

                "카운터" -> {
                    CounterScreen()
                }
            }

//            Screen(title = items[index])
        }
    }
}
