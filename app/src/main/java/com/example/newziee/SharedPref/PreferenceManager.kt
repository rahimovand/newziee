package com.example.newziee.SharedPref
import android.content.Context

class PreferenceManager(
    context: Context
) {
    private val sharedPreferences = context.getSharedPreferences("Infos", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()


    fun saveData(
        key: String, value: String
    ) {
        editor.putString(key, value)
        editor.commit()

    }

    fun getData(
        key: String, defaultValue: String
    ) = sharedPreferences.getString(key, defaultValue) ?: defaultValue

}