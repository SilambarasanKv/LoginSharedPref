package com.example.loginsharedpref

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        isRemembered = sharedPreferences.getBoolean("CHECKBOX", false)

        if (isRemembered) {
            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnLogin.setOnClickListener {
            var name: String = etEnterYourName.text.toString()
            var password: Int = etEnterYourPassword.text.toString().toInt()
            var checked: Boolean = checkBox.isChecked()

            var editor: SharedPreferences.Editor = sharedPreferences.edit()

            editor.putString("NAME", name)
            editor.putInt("PASSWORD", password)
            editor.putBoolean("CHECKBOX", checked)
            editor.apply()

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
