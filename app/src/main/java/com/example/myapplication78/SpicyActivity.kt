package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class SpicyActivity : AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var spicyBtn : RadioButton
    lateinit var notspicyBtn : RadioButton
    lateinit var nextBtn : Button
    lateinit var rdoGrp : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spicy)

        title = "메추리"
        returnBtn = findViewById<Button>(R.id.returnbtn)
        spicyBtn = findViewById<RadioButton>(R.id.spicyBtn)
        notspicyBtn = findViewById<RadioButton>(R.id.notspicyBtn)
        nextBtn = findViewById<Button>(R.id.nextBtn)
        rdoGrp = findViewById<RadioGroup>(R.id.radioGroup)

        var inIntent = intent
        var mainChked = inIntent.getStringExtra("mainBtn")
        var mealChked = inIntent.getStringExtra("mealBtn")
        if(mainChked.isNullOrEmpty()){
            mainChked = ""
        }
        if(mealChked.isNullOrEmpty()){
            mealChked = ""
        }

        returnBtn.setOnClickListener {
            val intent = Intent(this, MealActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        nextBtn.setOnClickListener{
            val intent = Intent(this, SoupActivity::class.java)
            when(rdoGrp.checkedRadioButtonId){

                R.id.spicyBtn -> {
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("mealBtn", mealChked)
                    intent.putExtra("spicyBtn", "spicy")
                }
                R.id.notspicyBtn -> {
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("mealBtn", mealChked)
                    intent.putExtra("spicyBtn", "notspicy")
                }

            }
            startActivity(intent)
            }
    }

    }
