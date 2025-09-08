package com.example.rpwg.RandomPasswordGenerator.data

import com.example.rpwg.RandomPasswordGenerator.data.model.Password
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.Sort
import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmUUID
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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
            .schemaVersion(1)
            .build()

        // 접근할 수 있는 realm 디비 객체 만들어냄
        this.realm = Realm.open(config)
    }


    @OptIn(DelicateCoroutinesApi::class)
    // 비밀번호를 추가한다
    fun addPassword(
        memo: String,
        password: String
    ) {

        val password = Password().apply {
            this.memo = memo
            this.password = password
        }

        GlobalScope.launch {
            realm.write { // this : MutableRealm
                val passwd = copyToRealm(password)
            }
        }
    }


    fun sortASCENDING() : Flow<List<Password>> { // 내림차순
        return realm.query<Password>().sort("generateTime", Sort.DESCENDING).find().asFlow()
            .map {
                it.list.toList()
            }
    }

    fun sortDESCENDING() : Flow<List<Password>> { // 오름차순
        return realm.query<Password>().sort("generateTime", Sort.ASCENDING).find().asFlow()
            .map {
                it.list.toList()
            }
    }

    @OptIn(DelicateCoroutinesApi::class)
    // 비밀번호를 삭제한다
    fun removePassword(id : RealmUUID?){

        GlobalScope.launch {

            realm.write {
                // 먼저 지울 비밀번호를 찾는다 - 쿼리
                val deleteToPassword: Password = query<Password>("uuid == $0", id).find().first()

                delete(deleteToPassword)
            }
        }
    }

    // 아이템을 수정한다
    fun updatePassword(id: RealmUUID?, updatedContent: String, time: RealmInstant){

        GlobalScope.launch {

            realm.write {
                // 먼저 수정할 아이템을 찾는다 - 쿼리
                val itemToUpdate: Password = query<Password>("uuid == $0", id).find().first()

                itemToUpdate.memo = updatedContent
                itemToUpdate.generateTime = time
                itemToUpdate.isEdit = true
            }
        }
    }
}