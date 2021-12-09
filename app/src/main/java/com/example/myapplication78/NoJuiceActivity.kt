package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class NoJuiceActivity : AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var bakeryBtn : RadioButton
    lateinit var iceBtn : RadioButton
    lateinit var fruitsBtn : RadioButton
    lateinit var nextBtn : Button
    lateinit var rdoGrp : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_juice)

        returnBtn = findViewById<Button>(R.id.returnbtn)
        bakeryBtn = findViewById<RadioButton>(R.id.bakeryBtn)
        iceBtn = findViewById<RadioButton>(R.id.iceBtn)
        fruitsBtn = findViewById<RadioButton>(R.id.fruitsBtn)
        nextBtn = findViewById<Button>(R.id.nextBtn)
        rdoGrp = findViewById<RadioGroup>(R.id.radioGroup)

        var inIntent = intent
        var mainChked = inIntent.getStringExtra("mainBtn")
        var dessertChked = inIntent.getStringExtra("dessert")

        returnBtn.setOnClickListener {
            val intent = Intent(this, DessertActivity::class.java)
            startActivity(intent) }

        nextBtn.setOnClickListener{
            val intent = Intent(this, MenuList::class.java)
            when(rdoGrp.checkedRadioButtonId){
                R.id.bakeryBtn -> {
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("mainBtn", dessertChked)
                    intent.putExtra("nojuiceBtn", "bakery")
                }
                R.id.iceBtn -> {
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("mainBtn", dessertChked)
                    intent.putExtra("nojuiceBtn", "ice")
                }
                R.id.fruitsBtn -> {
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("mainBtn", dessertChked)
                    intent.putExtra("nojuiceBtn", "fruits")
                }
            }
            startActivity(intent)
        }


    }
}