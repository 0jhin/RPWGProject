package com.example.rpwg.PopularSearches.Layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.rpwg.PopularSearches.Components.SearchBar
import com.example.rpwg.PopularSearches.GlobalTimer
import com.example.rpwg.PopularSearches.Screen.PopularSearches
import java.util.Date

@Composable
fun popluerLayout(modifier: Modifier = Modifier) {

    val currentTime = GlobalTimer.currentTimeEvent.collectAsState(Date())

    Column(
        modifier = modifier
    ) {
        Text("${currentTime.value}")
        Button(onClick = {
            GlobalTimer.startTimer()
        }) {
            Text("타이머 시작")
        }
        SearchBar()
        PopularSearches()
    }

}