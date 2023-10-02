package com.indipage.data.datasource

import android.content.SharedPreferences
import androidx.core.content.edit
import com.indipage.domain.SharedPreferenceToken
import javax.inject.Inject

class TokenImpl @Inject constructor(
    private val prefs: SharedPreferences
) : SharedPreferenceToken {
    override var token: String
        get() = prefs.getString("AccessToken", "") ?: ""
        set(value) = prefs.edit { putString("AccessToken", value) }

    override var first:Boolean
        get() = prefs.getBoolean("First",false)
        set(value)=prefs.edit{putBoolean("First",value)}

    override var checkLogin : Boolean
        get() = prefs.getBoolean("CheckLogin",false)
        set(value) = prefs.edit{putBoolean("CheckLogin",value)}
}