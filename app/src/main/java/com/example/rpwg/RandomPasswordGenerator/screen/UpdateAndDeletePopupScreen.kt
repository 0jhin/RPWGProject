package com.example.rpwg.RandomPasswordGenerator.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun UpdateAndDeletePopupScreen(
    value: String,
    onValueChange: (String) -> Unit,
    confirmButton: () -> Unit,
    deleteButton: () -> Unit,
    closedButton: () -> Unit
    ) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .zIndex(1f)
            .background(Color.Black.copy(0.8f))
            .clickable(
                enabled = false,
                onClick = {}
            )
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(28.dp, alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(400.dp)
                .height(300.dp)
                .background(Color.White)

        ) {
            OutlinedTextField(
                value = value,
                onValueChange = { onValueChange(it) },
                label = { Text("메모") }
            )
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(280.dp)
                    .height(44.dp)
                    .clip(shape = RoundedCornerShape(12))
                    .background(Color(0xFFc5bae3))
                    .clickable(onClick = { confirmButton() })
            ) {
                Text("수정", fontSize = 20.sp)
            }
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(280.dp)
                    .height(44.dp)
                    .clip(shape = RoundedCornerShape(12))
                    .background(Color(0xFFc5bae3))
                    .clickable(onClick = { deleteButton() })

            ) {
                Text("삭제", fontSize = 20.sp)
            }
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(280.dp)
                    .height(44.dp)
                    .clip(shape = RoundedCornerShape(12))
                    .background(Color(0xFFc5bae3))
                    .clickable(onClick = { closedButton() })

            ) {
                Text("닫기", fontSize = 20.sp)
            }
        }
    }
}