package com.example.rpwg.RandomPasswordGenerator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PasswordListForm(time: String, memo: String?, isEdit: Boolean, passwd: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.LightGray)
            .clickable(onClick = { onClick() })
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (isEdit) "수정일자 : $time" else "생성일자 : $time",
//                modifier = Modifier.align(alignment = Alignment.End)
                )
                if (isEdit) {
                    Text("(수정됨)", color = Color.Red)
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                Text("메모 : ", fontSize = 24.sp, fontWeight = Bold)
                SelectionContainer { Text(memo ?: "", fontSize = 24.sp, fontWeight = Bold) }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                Text("비밀번호 : ", fontSize = 24.sp, fontWeight = Bold)
                SelectionContainer { Text(passwd, fontSize = 24.sp, fontWeight = Bold) }

            }
        }
    }
}