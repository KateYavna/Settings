package com.example.settings

import android.content.Context


class SharedPrefManager (val context: Context) {
    private val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)


    fun setText  ( kea :String, text: String){
        prefs.edit().putString(kea,text).apply()
    }
    fun getText (kea: String) :String {
        val text:String =
            if (prefs.getString(kea,"input nick") != null)
                prefs.getString(kea,"input nick")!!
            else "input nick"
        return text

    }


    fun setSwitch  ( kea :String, position: Boolean){
       prefs.edit().putBoolean(kea,position).apply()
    }
    fun getSwitch (kea: String) :Boolean {
        val position:Boolean =
            if (prefs.getBoolean(kea,false) != null)
                prefs.getBoolean(kea,false)!!
        else false
        return position

    }

}
