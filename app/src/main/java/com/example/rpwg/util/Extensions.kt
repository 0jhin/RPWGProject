package com.example.rpwg.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

fun String.toStyledAnnotatedString(): AnnotatedString {
    return buildAnnotatedString {
        append(this@toStyledAnnotatedString) // Append the original string
        // You can add styles or annotations based on your needs
        // For example, to make a part of the string bold:
        val startIndex = this@toStyledAnnotatedString.indexOf("important")
        if (startIndex != -1) {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Blue)) {
                append(this@toStyledAnnotatedString.substring(startIndex, startIndex + "important".length))
            }
        }
    }
}