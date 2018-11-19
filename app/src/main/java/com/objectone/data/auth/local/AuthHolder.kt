package com.objectone.data.auth.local

import android.content.SharedPreferences
import io.reactivex.Single

class AuthHolder(val sharedPrefs: SharedPreferences) {

    /**
     * All calls to API should start with this check.
     */
    fun isLogined(): Single<Boolean> {
        // TODO: implement
        return Single.just(true)
    }
}