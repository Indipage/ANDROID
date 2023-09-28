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
}