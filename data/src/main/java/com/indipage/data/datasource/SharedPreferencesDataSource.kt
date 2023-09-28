package com.indipage.data.datasource

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesDataSource @Inject constructor(
    private val prefs: SharedPreferences
) {
    var accessToken: String?
        get() = prefs.getString("AccessToken", null)
        set(value) = prefs.edit { putString("AccessToken", value) }

}