package com.example.sweaty

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

object UserData: AppCompatActivity() {
    private const val SHARED_PREF = "sharedPref"
    private lateinit var preferences: SharedPreferences
    private val HEIGHT = Pair("height", 0)
    private val WEIGHT = Pair("weight", 0)
    private val GENDER = Pair("gender", false)

    fun init(context: Context) {
        preferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var height: Int
        get() = preferences.getInt(HEIGHT.first, HEIGHT.second)
        set(height) = preferences.edit{
            it.putInt(HEIGHT.first, height)
        }


    var weight: Int
        get() = preferences.getInt(WEIGHT.first, WEIGHT.second)
        set(weight) = preferences.edit{
            it.putInt(WEIGHT.first, weight)
        }

    var gender: Boolean
        get() = preferences.getBoolean(GENDER.first, GENDER.second)
        set(gender) = preferences.edit{
            it.putBoolean(GENDER.first, gender)
        }
}