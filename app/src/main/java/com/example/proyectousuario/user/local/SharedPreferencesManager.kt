package com.example.proyectousuario.user.local

import android.content.Context
import android.content.SharedPreferences
import com.example.proyectousuario.user.entity.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.Exception
import java.lang.reflect.Type

object SharedPreferencesManager {

    private const val PREFS_NAME = "MyPreference"
    private const val MODE = Context.MODE_PRIVATE
    private const val USER_KEY = "USER_KEY"

    fun setUser(context: Context, user : User){
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, MODE)
        val editor: SharedPreferences.Editor = prefs.edit()
        val gson = Gson()
        val json: String = gson.toJson(user)
        editor.putString(USER_KEY, json)
        editor.apply()
    }

    fun getUser(context: Context) : User? {
        return try {
            val prefs =
                context.getSharedPreferences(PREFS_NAME, MODE)
            val json = prefs.getString(USER_KEY, "")
            val gson: Gson = GsonBuilder().create()
            val type: Type = object : TypeToken<User>() {}.type
            val user: User = gson.fromJson(json, type)
            user
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun removeUser(context: Context){
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, MODE)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}