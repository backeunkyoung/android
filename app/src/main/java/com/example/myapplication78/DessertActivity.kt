package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class DessertActivity : AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var juiceBtn : RadioButton
    lateinit var nojuiceBtn : RadioButton
    lateinit var nextBtn : Button
    lateinit var rdoGrp : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dessert)

        returnBtn = findViewById<Button>(R.id.returnbtn)
        juiceBtn = findViewById<RadioButton>(R.id.juiceBtn)
        nojuiceBtn = findViewById<RadioButton>(R.id.nojuiceBtn)
        nextBtn = findViewById<Button>(R.id.nextBtn)
        rdoGrp = findViewById<RadioGroup>(R.id.radioGroup)

        var inIntent = intent
        var mainChked = inIntent.getStringExtra("mainBtn")

        returnBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent) }

        nextBtn.setOnClickListener{

            when(rdoGrp.checkedRadioButtonId){
                R.id.juiceBtn -> {
                    val intent = Intent(this, JuiceActivity::class.java)
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("dessertBtn", "juice")
                    startActivity(intent)
                }
                R.id.nojuiceBtn -> {
                    val intent = Intent(this, NoJuiceActivity::class.java)
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("dessertBtn", "nojuice")
                    startActivity(intent)
                }
            }

        }

    }
}