package com.example.rpwg.RandomPasswordGenerator.data.model

import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.RealmUUID

class Password : RealmObject {

    var uuid: RealmUUID = RealmUUID.random()

    var memo: String? = null

    var isEdit: Boolean = false

    var password: String = ""

    var generateTime: RealmInstant = RealmInstant.now()
}
