package com.example.myapplication78

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast

class TempActivity : AppCompatActivity() {


    lateinit var returnBtn : Button
    lateinit var nextBtn : Button
    lateinit var hotBtn : RadioButton
    lateinit var coldBtn : RadioButton
    lateinit var normalBtn : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)

        title = "메추리"

        returnBtn = findViewById<Button>(R.id.returnbtn)
        hotBtn = findViewById<RadioButton>(R.id.hotBtn)
        coldBtn = findViewById<RadioButton>(R.id.coldBtn)
        normalBtn = findViewById<RadioButton>(R.id.normalBtn)
        nextBtn = findViewById<Button>(R.id.nextBtn)

        returnBtn.setOnClickListener {
            val intent = Intent(this, SpicyActivity::class.java)
            startActivity(intent) }
        nextBtn.setOnClickListener{
            val intent = Intent(this, SoupActivity::class.java)
            startActivity(intent)
        }

    }

}
