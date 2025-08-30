package com.example.rpwg.RandomPasswordGenerator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LongButton(onClick: () -> Unit, text: String) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(300.dp)
            .height(60.dp)
            .clip(shape = RoundedCornerShape(20))
            .background(Color(0xFFc5bae3))
            .clickable(onClick = { onClick() })
    ) {
        Text(text, fontSize = 24.sp)
    }
}