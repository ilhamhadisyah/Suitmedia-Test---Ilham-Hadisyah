package com.ilhamhadisyah.suitmediatest.utils

import android.content.Context

class PreferencesManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("suitmedia", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    var nameUser
        get() = sharedPreferences.getString("name", "")
        set(value) {
            editor.putString("name", value).commit()
        }
}