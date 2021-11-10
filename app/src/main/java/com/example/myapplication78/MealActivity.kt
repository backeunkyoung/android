package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton

class MealActivity : AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var riceBtn : RadioButton
    lateinit var noodleBtn : RadioButton
    lateinit var breadBtn : RadioButton
    lateinit var nextBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal)

        returnBtn = findViewById<Button>(R.id.returnbtn)
        riceBtn = findViewById<RadioButton>(R.id.riceBtn)
        noodleBtn = findViewById<RadioButton>(R.id.noodleBtn)
        breadBtn = findViewById<RadioButton>(R.id.breadBtn)
        nextBtn = findViewById<Button>(R.id.nextBtn)

        returnBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent) }

        nextBtn.setOnClickListener{
            val intent = Intent(this, SpicyActivity::class.java)
            startActivity(intent)}
    }

    }
