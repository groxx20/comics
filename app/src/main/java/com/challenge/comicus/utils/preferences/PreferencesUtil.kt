package com.challenge.comicus.utils.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by Pavel on 08/09/2020.
 **/

class PreferencesUtil @Inject constructor(context: Context) {

    companion object {
        const val USER_PREF_PACKAGE_NAME = "com.challenge.comicus.userpreferences"
    }

    private val userPreferences: SharedPreferences =
        context.getSharedPreferences(USER_PREF_PACKAGE_NAME, Context.MODE_PRIVATE)


    fun putInt(key: String, value: Int): Boolean {
        val editor: SharedPreferences.Editor = userPreferences.edit()
        editor.putInt(key, value)
        return editor.commit()
    }

    fun getInt(key: String, defaultValue: Int): Int = userPreferences.getInt(key, defaultValue)
}