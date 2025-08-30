package com.example.rpwg.RandomPasswordGenerator.data.model

import io.realm.kotlin.types.RealmObject

class Password : RealmObject {
    var memo: String? = null
    var password: String = ""
}
