package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton

class SecondActivity : AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var mealBtn : RadioButton
    lateinit var dessertBtn : RadioButton
    lateinit var nextBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "메추리"
        returnBtn = findViewById<Button>(R.id.returnbtn)
        mealBtn = findViewById<RadioButton>(R.id.mealBtn)
        dessertBtn = findViewById<RadioButton>(R.id.dessertBtn)
        nextBtn = findViewById<Button>(R.id.nextBtn)

        returnBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }

        nextBtn.setOnClickListener{
            val intent = Intent(this, MealActivity::class.java)
            startActivity(intent)}
        }


    }

