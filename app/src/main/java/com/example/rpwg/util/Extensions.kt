package com.example.rpwg.util

import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import io.realm.kotlin.types.RealmInstant
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

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

// Date -> 문자열
fun Date.toDateString(pattern: String = "yyyy-MM-dd HH:mm:ss") : String {
    val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return dateFormat.format(this)
}


fun RealmInstant.toDateString() : String {
    val instant = Instant.ofEpochSecond(this.epochSeconds, this.nanosecondsOfSecond.toLong())
    val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분").withZone(ZoneId.systemDefault())
    return formatter.format(instant)
}