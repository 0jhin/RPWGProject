package com.example.rpwg.Kihya.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication0808.ui.component.appTitleTextStyle
import com.example.myapplication0808.ui.component.headerCategoryTextStyle
import com.example.myapplication0808.ui.component.locationTextStyle


enum class ButtonType{
    MAP, CART
}

//@Preview(showBackground = false)
@Composable
fun KihyaHeader(onClick: (ButtonType) -> Unit) {
    Column(verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(top = 14.dp, start = 14.dp, end = 14.dp)
            .height(156.dp)
            .fillMaxWidth()

    ) {
        TopIcons(onClick)
        SearchBar()
        CategoryBar()
    }
}

@Composable
fun TopIcons(onClick: (ButtonType) -> Unit) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.White)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .width(136.dp)
        ) {
            Text("키햐", style = appTitleTextStyle)
            UserLocation(onClick)
        }
        ShoppingCartIcon(onClick)
    }
}


@Composable
fun UserLocation(onClick: (ButtonType) -> Unit) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(32.dp)
            .width(80.dp)
            .background(Color(0xFF20252b), shape = RoundedCornerShape(50))
            .clip(shape = RoundedCornerShape(50))
            .clickable(onClick = {onClick(ButtonType.MAP)})
            .clipToBounds()

    ) {
        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = "위치",
            tint = Color(0xFFdddddd),
            modifier = Modifier
                .size(16.dp)
        )
        Text("수을방", style = locationTextStyle)
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = ">",
            tint = Color(0xFFdddddd),
            modifier = Modifier
                .size(16.dp)
        )
    }
}

@Composable
fun SearchBar() {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color(0xFFf5f5f5), shape = RoundedCornerShape(15))
            .clip(shape = RoundedCornerShape(15))
            .clickable(onClick = {})
            .clipToBounds()
    ) {
        Text("검색바")
    }
}

@Composable
fun ShoppingCartIcon(onClick: (ButtonType) -> Unit) {
    Icon(
        imageVector = Icons.Default.ShoppingCart,
        contentDescription = "장바구니",
        tint = Color(0xFFdddddd),
        modifier = Modifier
            .size(40.dp)
            .clip(shape = RoundedCornerShape(50))
            .clickable(onClick = {onClick(ButtonType.CART)})
            .clipToBounds()
    )
}

@Composable
fun CategoryBar() {
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(44.dp)
            .fillMaxWidth()
            .background(Color.White)
            .horizontalScroll(rememberScrollState())
    ) {
        HeaderCategory("추천")
        HeaderCategory("해외직구")
        HeaderCategory("우리술")
        HeaderCategory("위스키")
        HeaderCategory("와인")
        HeaderCategory("사케")
        HeaderCategory("리큐르")
        HeaderCategory("맥주")
        HeaderCategory("논알콜")
    }
}

@Composable
fun HeaderCategory(name: String) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxHeight()
            .clickable(onClick = {})
            .padding(8.dp)
    ) {
        Text(name, style = headerCategoryTextStyle)
    }
}