package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton


class MenuInfo3: AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var returnbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_info3)
        title = "메추리"
        returnbtn = findViewById(R.id.returnbtn)
        returnBtn = findViewById<Button>(R.id.returnBtn1)


        returnbtn.setOnClickListener {
         /*   val intent = Intent(this, MenuList::class.java)
            startActivity(intent)*/
            super.onBackPressed()
        }

        returnBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }


    }
}

