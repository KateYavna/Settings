package com.example.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import com.google.android.material.slider.Slider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val keaLanguage = "language"
    val keaGraphics = "graphics"
    val keaAutosave = "autosave"
    val keaText = "text"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swLanguage.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) { SharedPrefManager(this).setSwitch(keaLanguage,true) }
            else SharedPrefManager(this).setSwitch(keaLanguage,false)
        }
        swGraphics.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {SharedPrefManager(this).setSwitch(keaGraphics,true) }
            else SharedPrefManager(this).setSwitch(keaGraphics,false)
        }
        swAutosave.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {SharedPrefManager(this).setSwitch(keaAutosave,true) }
            else SharedPrefManager(this).setSwitch(keaAutosave,false)
        }
        etNick.afterTextChanged  {SharedPrefManager(this).setText(keaText,etNick.text.toString())}
        etNick.setText(SharedPrefManager(this).getText(keaText))

        if (SharedPrefManager(this).getSwitch(keaLanguage).equals(true)) swLanguage.isChecked = true
        if (SharedPrefManager(this).getSwitch(keaGraphics).equals(true)) swGraphics.isChecked = true
        if (SharedPrefManager(this).getSwitch(keaAutosave).equals(true)) swAutosave.isChecked = true


    }

    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }
        })
    }


}