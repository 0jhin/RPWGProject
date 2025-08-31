package com.example.rpwg.util

import androidx.compose.runtime.mutableStateListOf
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
import kotlin.math.roundToInt

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

fun RandomPasswordGenerated(sliderPosition: Float) : String {
    val characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_+=[]{}|;:,.<>?" // 뽑아낼 문자
    val passwdStringList = mutableListOf<String>() // 뽑아낸 문자 담아둘 리스트
    var isPasswordCorrect = true
    var generatedPassword = ""
    while (isPasswordCorrect) {
        passwdStringList.clear() // 임시 리스트 초기화
        for (i in 1..sliderPosition.roundToInt()) { // 1 부터 슬라이더 숫자 만큼 반복
            // characters에서 랜덤한 문자를 리스트에 넣는다
            passwdStringList.add(characters[(0..(characters.count() - 1)).random()].toString())
        }
        // 완성된 리스트를 하나의 문자열로 만든다
        generatedPassword = passwdStringList.joinToString(separator = "") { it.toString() }
        // 비밀번호 요건이 맞춰지면 반복 탈출
        if (hasAllPasswordRequirements(generatedPassword)) {
            isPasswordCorrect = false
        }
    }
    return generatedPassword
}

fun hasAllPasswordRequirements(password: String): Boolean {
    val passwordRequirements = listOf(
        Regex(".*[a-z].*"),      // 소문자
        Regex(".*[A-Z].*"),      // 대문자
        Regex(".*[0-9].*"),        // 숫자
        Regex(".*[\\s\\S]*?[!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?].*") // 특수문자
    )

    // all 함수는 리스트의 모든 조건이 true일 때만 true를 반환
    return passwordRequirements.all { it.matches(password) }
}