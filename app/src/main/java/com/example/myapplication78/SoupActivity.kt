package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class SoupActivity : AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var yesBtn : RadioButton
    lateinit var noBtn : RadioButton
    lateinit var nextBtn : Button
    lateinit var rdoGrp : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soup)

        title = "메추리"
        returnBtn = findViewById<Button>(R.id.returnbtn)
        yesBtn = findViewById<RadioButton>(R.id.yesBtn)
        noBtn = findViewById<RadioButton>(R.id.noBtn)
        nextBtn = findViewById<Button>(R.id.nextBtn)
        rdoGrp = findViewById<RadioGroup>(R.id.radioGroup)

        var inIntent = intent
        var mainChked = inIntent.getStringExtra("mainBtn")
        var mealChked = inIntent.getStringExtra("mealBtn")
        var spicyChked = inIntent.getStringExtra("spicyBtn")

        if(mainChked.isNullOrEmpty()){
            mainChked = ""
        }
        if(mealChked.isNullOrEmpty()){
            mealChked = ""
        }
        if(spicyChked.isNullOrEmpty()){
            spicyChked = ""
        }

        returnBtn.setOnClickListener {
            val intent = Intent(this, SpicyActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        nextBtn.setOnClickListener{
            val intent = Intent(this, MenuList::class.java)
            when(rdoGrp.checkedRadioButtonId){

                R.id.yesBtn -> {
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("mealBtn", mealChked)
                    intent.putExtra("mainBtn", spicyChked)

                    intent.putExtra("soupBtn", "yes")
                }
                R.id.noBtn -> {
                    intent.putExtra("mainBtn", mainChked)
                    intent.putExtra("mealBtn", mealChked)
                    intent.putExtra("mainBtn", spicyChked)

                    intent.putExtra("soupBtn", "no")
                }

            }
            startActivity(intent)

        }

    }

}
