package com.example.rpwg.Kihya.Component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication0808.ui.component.shoppingCartTextStyle

@Composable
fun ShoppingCartTop() {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.White)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "<",
                tint = Color(0xFF595959),
                modifier = Modifier
                    .size(50.dp)
            )
            Text("장바구니", style = shoppingCartTextStyle, modifier = Modifier
                .align(Alignment.Center)
            )
        }
        Row(
        ) {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .weight(1f)
                    .border(border = BorderStroke(width = 2.dp, color = Color(0xFFdddddd)))
                    .background(Color.White)
            ) {
                Text("장바구니", modifier = Modifier.align(alignment = Alignment.Center))
            }
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .weight(1f)
                    .border(border = BorderStroke(width = 2.dp, color = Color(0xFFdddddd)))
                    .background(Color.White)

            ) {
                Text("최근 본 상품", modifier = Modifier.align(alignment = Alignment.Center))
            }
        }
    }
}





@Composable
fun CartList() {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "<",
            tint = Color(0xFF595959),
            modifier = Modifier
                .border(border = BorderStroke(width = 2 .dp, color = Color(0xFFdddddd)), shape = RoundedCornerShape(50))
                .size(100.dp)
        )
        Text("장바구니에 담긴 상품이 없습니다.", modifier = Modifier.padding(top = 16.dp))
        Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "<",
            tint = Color(0xFF595959),
            modifier = Modifier
                .border(border = BorderStroke(width = 2 .dp, color = Color(0xFFdddddd)), shape = RoundedCornerShape(50))
                .size(100.dp)
        )
        Text("장바구니에 담긴 상품이 없습니다.", modifier = Modifier.padding(top = 16.dp))
        Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "<",
            tint = Color(0xFF595959),
            modifier = Modifier
                .border(border = BorderStroke(width = 2 .dp, color = Color(0xFFdddddd)), shape = RoundedCornerShape(50))
                .size(100.dp)
        )
        Text("장바구니에 담긴 상품이 없습니다.", modifier = Modifier.padding(top = 16.dp))
        Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "<",
            tint = Color(0xFF595959),
            modifier = Modifier
                .border(border = BorderStroke(width = 2 .dp, color = Color(0xFFdddddd)), shape = RoundedCornerShape(50))
                .size(100.dp)
        )
        Text("장바구니에 담긴 상품이 없습니다.", modifier = Modifier.padding(top = 16.dp))
        Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "<",
            tint = Color(0xFF595959),
            modifier = Modifier
                .border(border = BorderStroke(width = 2 .dp, color = Color(0xFFdddddd)), shape = RoundedCornerShape(50))
                .size(100.dp)
        )
        Text("장바구니에 담긴 상품이 없습니다.", modifier = Modifier.padding(top = 16.dp))
        Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "<",
            tint = Color(0xFF595959),
            modifier = Modifier
                .border(border = BorderStroke(width = 2 .dp, color = Color(0xFFdddddd)), shape = RoundedCornerShape(50))
                .size(100.dp)
        )
        Text("장바구니에 담긴 상품이 없습니다.", modifier = Modifier.padding(top = 16.dp))
        Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "<",
            tint = Color(0xFF595959),
            modifier = Modifier
                .border(border = BorderStroke(width = 2 .dp, color = Color(0xFFdddddd)), shape = RoundedCornerShape(50))
                .size(100.dp)
        )
        Text("장바구니에 담긴 상품이 없습니다.", modifier = Modifier.padding(top = 16.dp))
        Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "<",
            tint = Color(0xFF595959),
            modifier = Modifier
                .border(border = BorderStroke(width = 2 .dp, color = Color(0xFFdddddd)), shape = RoundedCornerShape(50))
                .size(100.dp)
        )
        Text("장바구니에 담긴 상품이 없습니다.", modifier = Modifier.padding(top = 16.dp))
        Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "<",
            tint = Color(0xFF595959),
            modifier = Modifier
                .border(border = BorderStroke(width = 2 .dp, color = Color(0xFFdddddd)), shape = RoundedCornerShape(50))
                .size(100.dp)
        )
        Text("장바구니에 담긴 상품이 없습니다.", modifier = Modifier.padding(top = 16.dp))
    }
}