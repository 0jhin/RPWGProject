package com.example.rpwg.RandomPasswordGenerator.data

import io.realm.kotlin.Realm
import com.example.rpwg.RandomPasswordGenerator.data.model.Password
import io.realm.kotlin.RealmConfiguration
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


object RPWGRepository {

    // use the RealmConfiguration.Builder() for more options
//    val configuration = RealmConfiguration.create(schema = setOf(Password::class))
//    val realm = Realm.open(configuration)

    private val realm: Realm

    init {
        // 디비에 대한 설정이다
        val config = RealmConfiguration
            .Builder(
                // 스키마란?
                // 우리가 만든 클래스 -> 테이블로 만들어줘 라고 하는 것
                schema = setOf(Password::class)
            )
            // 스키마 버전이란? - 디비 버전 이다 - 무조건 올라감
            .schemaVersion(0)
            .build()

        // 접근할 수 있는 realm 디비 객체 만들어냄
        this.realm = Realm.open(config)
    }


    fun addPassword(
        memo: String = "",
        password: String = ""
    ) {

        val password = Password().apply {
            this.memo = "memo"
            this.password = "password"
        }

        GlobalScope.launch {
            realm.write { // this : MutableRealm
                val passwd = copyToRealm(password)
            }
        }
    }
}