package com.example.rpwg.Counter.Screen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.myapplication0814.components.titleTextStyle7
import com.example.rpwg.R

@Composable
fun CounterScreen() {
    var countValue = remember { mutableStateOf(1) }
    var priceValue = remember { mutableStateOf(12930) }

    Refactoring(count = countValue.value, price = priceValue.value,
        onClick = {
            when(it) {
                MyStateButton.Save -> {
                    Log.d("버튼 Save", "Save 버튼 눌림")

                }
                MyStateButton.Favorite -> {
                    Log.d("버튼 Favorite", "Favorite 버튼 눌림")
                }
                MyStateButton.Plus -> {
                    Log.d("버튼 Plus", "Plus 버튼 눌림")
                    countValue.value += 1
                    priceValue.value += 12930
                }
                MyStateButton.Minus -> {
                    Log.d("버튼 Minus", "Minus 버튼 눌림")
                    countValue.value -= 1
                    priceValue.value -= 12930
                }
            }
        }
    )
}

@Composable
fun Refactoring(
    onClick: (MyStateButton) -> Unit, optionbuttonText : String = "수량 저장하기", count: Int = 0, price: Int = 0, modifier: Modifier = Modifier) {
    MyWallpaper() {
        MyImage()
        // 물건 구매 버튼 세트
        ProduceBuyUI(onClick, optionbuttonText, count, price, modifier)
    }
}

@Composable
fun MyImage(imageName: Int = R.drawable.myimage2) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp)
    ) {
        Image(painter = painterResource(id = imageName),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}


@Composable
fun MyWallpaper(content: @Composable () -> Unit) {
    Column(verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.LightGray)
            .padding(bottom = 12.dp, start = 12.dp, end = 12.dp)
    ) {
        content()
    }
}

@Composable
fun ProduceBuyUI(onClick: (MyStateButton) -> Unit, optionbuttonText : String, count: Int, price: Int, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
//            .width(300.dp)
//            .fillMaxHeight()
            .height(150.dp)
            .background(Color(0xFFffffff), shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp))
            .padding(16.dp)
            .zIndex(1f)
    ) {
        // 상단 버튼, 가격 세트
        PriceButtonSet(onClick, count, price, modifier)
        // 스페이서
        RowSpacer(modifier = Modifier.weight(1f))
        // 하단 버튼 세트
        FavoriteAndOptionButtonSet(onClick,optionbuttonText, modifier)
    }
}

@Composable
fun PriceButtonSet(onClick: (MyStateButton) -> Unit, count: Int, price: Int, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        // + 1 - 부분
        PlusMinusButtonSet(onClick, count, modifier)
        // 가격표
        MyPriceTag(price, modifier = Modifier.weight(1f, fill = false))
    }
}

@Composable
fun PlusMinusButtonSet(onClick: (MyStateButton) -> Unit, count: Int, modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxHeight()
    ) {
        // 마이너스
        MinusButton(onClick, modifier)
        // 수량
        ProductCount(count, modifier = Modifier.weight(1f, fill = false))
        // 플러스
        PlusButton(onClick, modifier)
    }
}

@Composable
fun MinusButton(onClick: (MyStateButton) -> Unit,modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .size(32.dp)
            .background(Color(0xFFffffff))
            .border(border = BorderStroke(width = 1.dp, color = Color(0xFFdddddd)), shape = RoundedCornerShape(percent = 50))
            .clip(shape = RoundedCornerShape(percent = 50))
            .clickable(onClick = {onClick(MyStateButton.Minus)})
            .clipToBounds()
    ) {
        Text("-", style = titleTextStyle7)
    }
}

@Composable
fun ProductCount(count: Int, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
    ) {
        Text("$count", style = titleTextStyle7)
    }
}

@Composable
fun PlusButton(onClick: (MyStateButton) -> Unit, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .size(32.dp)
            .background(Color(0xFFffffff))
            .border(border = BorderStroke(width = 1.dp, color = Color(0xFFdddddd)), shape = RoundedCornerShape(percent = 50))
            .clip(shape = RoundedCornerShape(percent = 50))
            .clickable(onClick = {onClick(MyStateButton.Plus)})
            .clipToBounds()
    ) {
        Text("+", style = titleTextStyle7)
    }
}

@Composable
fun MyPriceTag(price: Int, modifier: Modifier = Modifier) {
    Text("${price}원", style = titleTextStyle7) //sibal 한글 때문이었네?

}

@Composable
fun RowSpacer(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier
    )
}

@Composable
fun FavoriteAndOptionButtonSet(onClick: (MyStateButton) -> Unit, optionbuttonText : String = "옵션 저장하기", modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        // 좋아요 버튼
        FavoriteButton(onClick, modifier)
        // 옵션 저장 버튼
        MyOptionButton(onClick, optionbuttonText, modifier)
    }
}

@Composable
fun FavoriteButton(onClick: (MyStateButton) -> Unit, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .size(40.dp)
            .background(Color(0xFFdddddd), shape = RoundedCornerShape(percent = 50))
            .clip(shape = RoundedCornerShape(percent = 50))
            .clickable(onClick = {onClick(MyStateButton.Favorite)})
            .clipToBounds()
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "좋아요",
            tint = Color(0xFFffffff),
            modifier = Modifier
                .size(20.dp)
        )
    }
}

@Composable
fun MyOptionButton(onClick: (MyStateButton) -> Unit, optionbuttonText: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .size(height = 40.dp, width = 280.dp)
            .background(Color(0xFFe95241), shape = RoundedCornerShape(8.dp))
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable(onClick = {onClick(MyStateButton.Save)})
            .clipToBounds()
    ) {
        Text("$optionbuttonText", style = titleTextStyle8)
    }
}

enum class MyStateButton {
    Plus, Minus, Favorite, Save
}