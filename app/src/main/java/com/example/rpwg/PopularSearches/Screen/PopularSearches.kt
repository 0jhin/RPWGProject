package com.example.rpwg.PopularSearches.Screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.rpwg.PopularSearches.GlobalTimer
import java.util.Date

@Composable
fun PopularSearches() {

    var popularSearchList = remember { mutableStateListOf("샴푸", "바디워시", "어쩌고", "저쩌고", "이러쿵", "저러쿵") }

    val currentTime = GlobalTimer.currentTimeEvent.collectAsState(Date())

    LaunchedEffect(Unit) {
        GlobalTimer.startTimer()
//        GlobalTimer.currentTimeEvent
//        GlobalTimer.currentTimeEvent.emit()
    }

    Text("${currentTime.value}")


}