package com.example.rpwg.RandomPasswordGenerator.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun PasswordNumSlider(value: Float, onValueChange: (Float) -> Unit) {




    Column {
        Slider(
            value = value,
            onValueChange = { onValueChange(it) },
            steps = 15,
            valueRange = 4f..20f,
            modifier = Modifier
                .width(300.dp)
        )
        Text(text = value.roundToInt().toString())
    }
}