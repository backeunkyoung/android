package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MealActivity : AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var riceBtn : RadioButton
    lateinit var noodleBtn : RadioButton
    lateinit var breadBtn : RadioButton
    lateinit var nextBtn : Button
    lateinit var rdoGrp : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal)

        rdoGrp = findViewById<RadioGroup>(R.id.radioGroup)
        returnBtn = findViewById<Button>(R.id.returnbtn)
        riceBtn = findViewById<RadioButton>(R.id.riceBtn)
        noodleBtn = findViewById<RadioButton>(R.id.noodleBtn)
        breadBtn = findViewById<RadioButton>(R.id.breadBtn)
        nextBtn = findViewById<Button>(R.id.nextBtn)

        var inIntent = intent
        var mainChked = inIntent.getStringExtra("mainBtn")
        if(mainChked.isNullOrEmpty()){
            mainChked = ""
        }

        returnBtn.setOnClickListener {
        /*    val intent = Intent(this, SecondActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()*/

            super.onBackPressed()
        }

        nextBtn.setOnClickListener{

            when(rdoGrp.checkedRadioButtonId){

                R.id.riceBtn -> {
                    val intent = Intent(this, SpicyActivity::class.java)
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("mealBtn", "Rice")
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
                R.id.noodleBtn -> {
                    val intent = Intent(this, SpicyActivity::class.java)
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("mealBtn", "Noodle")
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
                R.id.breadBtn -> {
                    val intent = Intent(this, MenuList::class.java)
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("mealBtn", "Bread")
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }

            }

        }
    }



    }
