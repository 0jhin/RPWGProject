package com.example.rpwg.RandomPasswordGenerator.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.rpwg.RandomPasswordGenerator.components.PasswordListForm
import com.example.rpwg.RandomPasswordGenerator.data.RPWGRepository
import com.example.rpwg.RandomPasswordGenerator.data.RPWGRepository.removePassword
import com.example.rpwg.RandomPasswordGenerator.data.RPWGRepository.updatePassword
import com.example.rpwg.util.toDateString
import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmUUID
import kotlinx.coroutines.launch
import java.util.Date

@Composable
fun SavedPasswordScreen() {

    val sort = remember { mutableStateOf(true) }
    val passwordList = if (sort.value) RPWGRepository.sortASCENDING().collectAsState(listOf()) else RPWGRepository.sortDESCENDING().collectAsState(listOf())
    val isPopupOpen = remember { mutableStateOf(false) }
    var popupMemo by remember { mutableStateOf("") }
    val isMemoChange = remember { mutableStateOf("") }
    val popupPasswd = remember { mutableStateOf("") }
    var popupUUID by remember { mutableStateOf<RealmUUID?>(null)} // 수정 아이템 UUID 보관
    val scope = rememberCoroutineScope()



    Box(

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp)
                    .padding(end = 12.dp)
            ) {
                Text("현재정렬 : ${if (sort.value) "최신순" else "오래된순"}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(140.dp)
                        .clickable(onClick = {
                            sort.value = !sort.value
                        })
                        .padding(top = 5.dp)
                )
            }
            passwordList.value.forEach {
                PasswordListForm(
                    time = it.generateTime.toDateString(),
                    memo = it.memo,
                    passwd = it.password,
                    isEdit = it.isEdit ,
                    onClick = {
                        popupMemo = it.memo ?: ""
                        isMemoChange.value = it.memo ?: ""
                        popupPasswd.value = it.password
                        popupUUID = it.uuid
                        isPopupOpen.value = true
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        if (isPopupOpen.value) {
            UpdateAndDeletePopupScreen(
                value = popupMemo,
                onValueChange = {newText -> popupMemo = newText},
                confirmButton = {
                    if (popupMemo != isMemoChange.value) {
                        updatePassword( // popupMemo의 값이 변경 되면 실행
                            id = popupUUID,
                            updatedContent = popupMemo,
                            time = RealmInstant.now()
                        )
                    }
                    popupMemo = ""
                    isMemoChange.value = ""
                    isPopupOpen.value = false
                },
                deleteButton = {
                    removePassword(popupUUID)
                    popupMemo = ""
                    isMemoChange.value = ""
                    isPopupOpen.value = false
                },
                closedButton = {
                    popupMemo = ""
                    isMemoChange.value = ""
                    isPopupOpen.value = false
                }
            )
        }
    }



}