package com.example.rpwg.OliveYoung.Data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.rpwg.OliveYoung.MyApp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// At the top level of your kotlin file:
// 헬스장 사물함
val Context.counterDataStore: DataStore<Preferences> by preferencesDataStore(name = "counter")

object LocalDataRepository {

    // 사물함 번호 - 키 - 열쇠
    val LOCAL_COUNT = intPreferencesKey("local_count")

    val context = MyApp.instance

    val localCountFlow: Flow<String> = context.counterDataStore.data
        .map { preferences ->
            // No type safety.
            val storedIntValue : Int = preferences[LOCAL_COUNT] ?: -99
            return@map storedIntValue
        }.map{
            if (it == -99) {
                return@map "데이터가 없습니다"
            } else {
                return@map "받은 데이터 : ${it}"
            }
        }


    val countFlow: Flow<Int> = context.counterDataStore.data
        .map { preferences ->
            // No type safety.
            val storedIntValue : Int = preferences[LOCAL_COUNT] ?: -99
            return@map storedIntValue
        }

    suspend fun countUp(){
        context.counterDataStore.edit { settings ->
            // 현재 저장되어있는 값을 가져온다 - 키 LOCAL_COUNT
            val currentCounterValue = settings[LOCAL_COUNT] ?: 0
            // 저장되어있는 값에다가 1을 추가해서 다시 넣는다.
            settings[LOCAL_COUNT] = currentCounterValue + 1
        }
    }

    suspend fun countDown(){
        context.counterDataStore.edit { settings ->
            // 현재 저장되어있는 값을 가져온다 - 키 LOCAL_COUNT
            val currentCounterValue = settings[LOCAL_COUNT] ?: 0
            // 저장되어있는 값에다가 1을 빼고 다시 넣는다.
            settings[LOCAL_COUNT] = currentCounterValue - 1
        }
    }

}