package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton

class SoupActivity : AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var yesBtn : RadioButton
    lateinit var noBtn : RadioButton
    lateinit var nextBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soup)

        title = "메추리"
        returnBtn = findViewById<Button>(R.id.returnbtn)
        yesBtn = findViewById<RadioButton>(R.id.yesBtn)
        noBtn = findViewById<RadioButton>(R.id.noBtn)
        nextBtn = findViewById<Button>(R.id.nextBtn)

        returnBtn.setOnClickListener {
            val intent = Intent(this, TempActivity::class.java)
            startActivity(intent) }

        nextBtn.setOnClickListener{
            val intent = Intent(this, MenuList::class.java)
            startActivity(intent)
        }

    }

}
