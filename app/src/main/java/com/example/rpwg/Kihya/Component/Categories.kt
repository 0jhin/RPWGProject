package com.example.rpwg.Kihya.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rpwg.R


@Composable
fun CategoriesList() {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(10.dp)
    ) {
        repeat(10) {
            Column(

            ) {
                Categories()
                Categories()
            }
        }
    }
}


@Composable
fun Categories() {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .clip(shape = RoundedCornerShape(12.dp))
                .clickable(onClick = {})
                .clipToBounds()
        ) {
            Image(painter = painterResource(R.drawable.categorie),
                contentDescription = "설명",
                modifier = Modifier
                    .size(60.dp)
            )

        }
        Text("카테고리 이름")
    }
}