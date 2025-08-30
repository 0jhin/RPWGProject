package com.example.rpwg.Kihya.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.myapplication0808.ui.component.footerIconTextStyle

@Composable
fun FooterMemuBar(modifier: Modifier = Modifier, homeClick: () -> Unit,
                  menuClick: () -> Unit,
                  searchClick: () -> Unit,
                  checkClick: () -> Unit,
                  personClick: () -> Unit
) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth()
            .height(60.dp)
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
    ) {
        FooterIcon(Icons.Default.Menu, "카테고리", "카테고리", menuClick)
        FooterIcon(Icons.Default.Search, "검색", "검색", searchClick)
        FooterIcon(Icons.Default.Home, "홈", "홈", homeClick)
        FooterIcon(Icons.Default.Check, "최근본상품", "최근본상품", checkClick)
        FooterIcon(Icons.Default.Person, "내정보", "내정보", personClick)
    }
}

@Composable
fun FooterIcon(icon: ImageVector, iconContentDescription: String, iconName: String, onClick: () -> Unit) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(60.dp)
            .clickable(onClick = {onClick()})
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconContentDescription,
            tint = Color(0xFF000000),
            modifier = Modifier
                .size(30.dp)
        )
        Text(iconName, style = footerIconTextStyle, modifier = Modifier
        )
    }
}