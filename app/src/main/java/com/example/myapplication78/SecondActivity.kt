package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class SecondActivity : AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var mealBtn : RadioButton
    lateinit var dessertBtn : RadioButton
    lateinit var nextBtn : Button
    lateinit var rdoGrp : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "메추리"
        returnBtn = findViewById<Button>(R.id.returnbtn)
        mealBtn = findViewById<RadioButton>(R.id.mealBtn)
        dessertBtn = findViewById<RadioButton>(R.id.dessertBtn)
        nextBtn = findViewById<Button>(R.id.nextBtn)
        rdoGrp = findViewById<RadioGroup>(R.id.radioGroup)


        returnBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        nextBtn.setOnClickListener{

            when(rdoGrp.checkedRadioButtonId){
                R.id.mealBtn -> {
                    val intent = Intent(this, MealActivity::class.java)
                    intent.putExtra("mainBtn", "meal")
                    startActivity(intent)
                }
                R.id.dessertBtn -> {
                    val intent = Intent(this, DessertActivity::class.java)
                    intent.putExtra("mainBtn", "dessert")
                    startActivity(intent)
                }
            }

            }
        }


    }

