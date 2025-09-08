package com.example.rpwg.RandomPasswordGenerator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TabComponent(modifier: Modifier = Modifier, title: String, color: Color, onClick: () -> Unit) {
    Box(
        modifier = modifier
//            .width(80.dp)
            .height(48.dp)
            .clip(shape = RoundedCornerShape(50))
            .background(color)
            .clickable(onClick = { onClick() })
            .padding(12.dp)
    ) {
        Text(title)
    }
}