package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class JuiceActivity : AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var caffBtn : RadioButton
    lateinit var decaffBtn : RadioButton
    lateinit var nextBtn : Button
    lateinit var rdoGrp : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juice)

        returnBtn = findViewById<Button>(R.id.returnbtn)
        caffBtn = findViewById<RadioButton>(R.id.caffBtn)
        decaffBtn = findViewById<RadioButton>(R.id.decaffBtn)
        nextBtn = findViewById<Button>(R.id.nextBtn)
        rdoGrp = findViewById<RadioGroup>(R.id.radioGroup)

        var inIntent = intent
        var mainChked = inIntent.getStringExtra("mainBtn")
        var dessertChked = inIntent.getStringExtra("dessertBtn")

        returnBtn.setOnClickListener {
            /*val intent = Intent(this, DessertActivity::class.java)
            startActivity(intent)*/
            super.onBackPressed()
        }

        nextBtn.setOnClickListener{
            val intent = Intent(this, MenuList::class.java)
            when(rdoGrp.checkedRadioButtonId){
                R.id.caffBtn -> {
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("dessertBtn", dessertChked)
                    intent.putExtra("juiceBtn", "TRUE")
                }
                R.id.decaffBtn -> {
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("dessertBtn", dessertChked)
                    intent.putExtra("juiceBtn", "FALSE")
                }
            }
            startActivity(intent)
        }

    }
}