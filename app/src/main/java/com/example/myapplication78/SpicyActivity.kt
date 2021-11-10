package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton

class SpicyActivity : AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var spicyBtn : RadioButton
    lateinit var notspicyBtn : RadioButton
    lateinit var nextBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spicy)

        title = "메추리"
        returnBtn = findViewById<Button>(R.id.returnbtn)
        spicyBtn = findViewById<RadioButton>(R.id.spicyBtn)
        notspicyBtn = findViewById<RadioButton>(R.id.notspicyBtn)
        nextBtn = findViewById<Button>(R.id.nextBtn)

        returnBtn.setOnClickListener {
            val intent = Intent(this, MealActivity::class.java)
            startActivity(intent) }

        nextBtn.setOnClickListener{
            val intent = Intent(this, TempActivity::class.java)
            startActivity(intent)}
    }

    }
