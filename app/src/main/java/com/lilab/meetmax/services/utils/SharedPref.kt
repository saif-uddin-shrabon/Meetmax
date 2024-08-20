package com.lilab.meetmax.services.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE

object SharedPref {
    fun storeData(
        userId: String,
        context: Context
    ) {
        val sharedPref = context.getSharedPreferences("users", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("userId", userId)
        editor.apply()
    }

    fun getUserId(context: Context): String {
        val sharedPreferences = context.getSharedPreferences("users", MODE_PRIVATE)
        return sharedPreferences.getString("userId", "")!!
    }

}