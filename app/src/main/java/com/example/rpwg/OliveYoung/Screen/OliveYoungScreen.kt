package com.example.rpwg.OliveYoung.Screen

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.ExtraBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.rpwg.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


val Context.popUpDataStore: DataStore<Preferences> by preferencesDataStore(name = "popup")


@Preview(showBackground = true)
@Composable
fun OliveYoungScreen(modifier: Modifier = Modifier) {
    val isPopUp = remember { mutableStateOf(true) }
    Box() {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            TopBar()
        }
        if (isPopUp.value) {
            AppStartedPopUp(modifier = modifier.zIndex(1f), onClick = {isPopUp.value = false})
        }
    }

}

@Composable
fun AppStartedPopUp(modifier: Modifier = Modifier, onClick: () -> Unit) {

    val isAutoOn = remember { mutableStateOf<Boolean>(true) }

    val pageItems: List<Int> = listOf(
        R.drawable.oliveyoung1,
        R.drawable.oliveyoung2,
        R.drawable.oliveyoung3,
        R.drawable.oliveyoung4
    )


    val scope = rememberCoroutineScope()

    val half = Int.MAX_VALUE / 2
    val remainder = half % pageItems.size

    val initialIndex = half - remainder

    val pagerState = rememberPagerState(
        initialPage = initialIndex,
        pageCount = { Int.MAX_VALUE }
    )

    val pagerIsDragged by pagerState.interactionSource.collectIsDraggedAsState()

    val pageInteractionSource = remember { MutableInteractionSource() }
    val pageIsPressed by pageInteractionSource.collectIsPressedAsState()

    val autoAdvance = !pagerIsDragged && !pageIsPressed

    // 팝업 박스
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black.copy(0.5f)) // 투명 배경
    ) {
        // 팝업 광고 화면 부분
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
                )
                .clip(shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .align(alignment = Alignment.BottomCenter)
        ) {
            // 자동 화면 전환
            if (autoAdvance) {
                LaunchedEffect(pagerState, pageInteractionSource) {
                    while (true) {
                        delay(2000)
                        if (isAutoOn.value) {
//                        val nextPage = (pagerState.currentPage + 1) % pageItems.size
                            val nextPage = pagerState.currentPage + 1
                            pagerState.animateScrollToPage(nextPage)
                        }
                    }
                }
            }

            // 자동 슬라이드 박스
            Box(
            ) {
                val itemIndex = pagerState.currentPage % pageItems.size
                val realItem = pageItems[itemIndex]
                // 자동 슬라이드 컨트롤러
                Box(
                    modifier = Modifier
                        .zIndex(1f)
                        .align(alignment = Alignment.TopEnd)
                        .padding(12.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .width(120.dp)
                    ) {
                        Icon(
                            imageVector = if (isAutoOn.value) Icons.Default.PlayArrow else Icons.Default.Clear,
                            contentDescription = if (isAutoOn.value) "재생" else "일시정지",
                            tint = Color.White,
                            modifier = Modifier
                                .background(Color.Black.copy(0.5f), shape = CircleShape)
                                .clickable(
                                    indication = null, // Disable the ripple effect
                                    interactionSource = remember { MutableInteractionSource() }
                                ) {
                                    isAutoOn.value = !isAutoOn.value
                                    Log.d("클릭됨", "클릭됨")
                                }

                        )
                        Row(
                            modifier = Modifier
                                .background(
                                    Color.Black.copy(0.5f),
                                    shape = androidx.compose.foundation.shape.RoundedCornerShape(50)
                                )
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                contentDescription = "이전",
                                tint = Color.White,
                                modifier = Modifier
                                    .clickable(
                                        indication = null, // Disable the ripple effect
                                        interactionSource = remember { MutableInteractionSource() }
                                    ) {
                                        scope.launch {
                                            val beforePage = pagerState.currentPage - 1
                                            pagerState.animateScrollToPage(beforePage)
                                        }
                                        Log.d("클릭됨", "클릭됨")
                                    }
                            )

                            Text("${itemIndex + 1} | ${pageItems.count()}", color = Color.White)

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = "다음",
                                tint = Color.White,
                                modifier = Modifier
                                    .clickable(
                                        indication = null, // Disable the ripple effect
                                        interactionSource = remember { MutableInteractionSource() }
                                    ) {
                                        scope.launch {
                                            val nextPage = pagerState.currentPage + 1
                                            pagerState.animateScrollToPage(nextPage)
                                        }
                                        Log.d("클릭됨", "클릭됨")
                                    }
                            )
                        }
                    }
                }
                // 넘어가는 화면들
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .height(240.dp)
                        .fillMaxWidth()
                        .background(Color(0xFFdddddd))
                        .clickable(
                            interactionSource = pageInteractionSource,
                            indication = LocalIndication.current
                        ) {
                            // Handle page click
                        }
                        .wrapContentSize(align = Alignment.Center)
                ) { page ->

                    val itemIndex = page % pageItems.size
                    val realItem = pageItems[itemIndex]

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(id = realItem),
                            contentDescription = "광고",
                            contentScale = ContentScale.Crop, // 이미지 꽉 차게 하는법
                            modifier = Modifier.fillMaxSize()
                        )
//                        Text(
//                            text = "이미지 $realItem",
//                            fontSize = 30.sp,
//                            textAlign = TextAlign.Center,
//                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()

            ) {
                Text(
                    "오늘 하루 보지 않기",
                    fontSize = 16.sp,
                    color = Color(0xFF9fa4a9),
                    modifier = Modifier
                        .clickable(
                            indication = null, // Disable the ripple effect
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            Log.d("클릭됨", "클릭됨")
                            onClick()
                        }
                        .padding(16.dp)
                )
                Text(
                    "닫기",
                    fontSize = 16.sp,
                    color = Color(0xFF9fa4a9),
                    modifier = Modifier
                        .clickable(
                            indication = null, // Disable the ripple effect
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            Log.d("클릭됨", "클릭됨")
                            onClick()
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(12.dp)
    ) {

        Row(

        ) {
            Title()
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowDown,
                contentDescription = "더보기",
                modifier = Modifier
                    .size(32.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .width(120.dp)
                .align(alignment = Alignment.CenterEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "검색",
                modifier = Modifier
                    .size(32.dp)
            )
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "알림",
                modifier = Modifier
                    .size(32.dp)
            )
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "장바구니",
                modifier = Modifier
                    .size(32.dp)
            )
        }
    }
}

@Composable
fun Title() {
    Text("OLIVE YOUNG", fontSize = 28.sp, fontWeight = ExtraBold)
}