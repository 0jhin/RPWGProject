package com.example.rpwg.RandomPasswordGenerator.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.rpwg.RandomPasswordGenerator.components.LongButton
import com.example.rpwg.RandomPasswordGenerator.components.PasswordNumSlider
import com.example.rpwg.RandomPasswordGenerator.data.RPWGRepository
import com.example.rpwg.layout.MainLayout
import com.example.rpwg.util.RandomPasswordGenerated
import com.example.rpwg.util.toStyledAnnotatedString
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


//@Preview(showBackground = true)
@Composable
fun RPWGScreen(modifier: Modifier = Modifier) {

    var text by remember { mutableStateOf("") } // 메모 필드

    var sliderPosition by remember { mutableFloatStateOf(8f) } // 슬라이더 정수 반올림 .roundToInt()


    val generatedPassword = remember { mutableStateOf<String>("") } // 리스트에서 가져온 완성된 패스워드

    val scope = rememberCoroutineScope() // 코루틴스코프


    // rememberSaveable - 화면회전이 되어도 데이터 안날라가게 함
//    var saver by rememberSaveable(stateSaver = TextFieldValue.Saver) {
//        mutableStateOf(TextFieldValue(text = text,
//            selection = TextRange(index = text.length)))
//    }

    // Retrieve a ClipboardManager object
    val clipboardManager = LocalClipboardManager.current

    Column(horizontalAlignment = Alignment.CenterHorizontally, // 전체 배경
        verticalArrangement = Arrangement.spacedBy(100.dp, alignment = Alignment.Bottom),
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp)
    ) { // 전체 배경

        Column(horizontalAlignment = Alignment.CenterHorizontally, // 메모 ~ 생성 된 비밀번호
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
//                .background(Color.Cyan)
                .height(240.dp)
        ) { // 메모 ~ 생성 된 비밀번호

            OutlinedTextField( // 메모 필드
                value = text,
                onValueChange = {newText -> text = newText},
                label = { Text("메모") }
            ) // 메모 필드
            PasswordNumSlider( // 비밀번호 슬라이더
                value = sliderPosition,
                onValueChange = { sliderPosition = it }
            ) // 비밀번호 슬라이더
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) { // 생성 된 비밀번호
                Text("생성 된 비밀번호 : ")
                SelectionContainer { Text(generatedPassword.value) }
                Button(enabled = generatedPassword.value.isNotEmpty(),
                    onClick = {
                        // Copy "Hello, clipboard" to the clipboard
                        clipboardManager.setText(generatedPassword.value.toStyledAnnotatedString())
                    }
                ) {
                    Text("복사")
                }
            } // 생성 된 비밀번호
        } // 메모 ~ 생성 된 비밀번호

        // ========================================================================================

        Column( // 생성 버튼 ~ 저장 버튼
            verticalArrangement = Arrangement.spacedBy(40.dp),
            modifier = Modifier
//                .background(Color.Blue)
                .padding(bottom = 60.dp)
        ) { // 생성 버튼 ~ 저장 버튼
            LongButton( // 생성 버튼
                onClick = { // onClick
                    generatedPassword.value = RandomPasswordGenerated(sliderPosition)
                }, // onClick
                text = "생성"
            ) // 생성 버튼
            LongButton( // 저장 버튼
                onClick = { // onClick
                    if (text.isNotEmpty()) {
                        RPWGRepository.addPassword(
                            memo = text,
                            password = generatedPassword.value
                        )
                    }
                    text = "" // 메모 필드 초기화
                }, // onClick
                text = "저장"
            ) // 저장 버튼
        } // 생성 버튼 ~ 저장 버튼
    } // 전체 배경



}




@Composable
fun SliderMinimalExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString())
    }
}
