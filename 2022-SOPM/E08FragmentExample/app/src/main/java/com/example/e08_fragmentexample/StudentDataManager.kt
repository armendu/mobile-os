package com.example.e08_fragmentexample

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class StudentDataManager(val context: Context) {
    fun saveList(studentName: String) {
        val editor: SharedPreferences = context.getSharedPreferences("SHARED_PREF", 0)
        editor.edit(commit = true) { putString(studentName, studentName) }
    }

    fun readList(): ArrayList<String> {
        val sharedPreferences = context.getSharedPreferences("SHARED_PREF", 0)
        val sharedPreferencesContents = sharedPreferences.all

        var arrayOfName = ArrayList<String>()
        for (content in sharedPreferencesContents) {
            arrayOfName.add(content.key)
        }

        return arrayOfName
    }
}