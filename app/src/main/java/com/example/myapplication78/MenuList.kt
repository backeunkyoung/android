package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton


class MenuList: AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var nextBtn : Button
    lateinit var Btn1 : Button
    lateinit var Btn2 : Button
    lateinit var Btn3 : Button
    lateinit var Btn4 : Button
    lateinit var img1 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_list)

        var inIntent = intent
        var mainChked = inIntent.getStringExtra("mainBtn")
        var mealChked = inIntent.getStringExtra("mealBtn")
        var spicyChked = inIntent.getStringExtra("spicyBtn")
        var soupChked = inIntent.getStringExtra("soupBtn")
        var juiceChked = inIntent.getStringExtra("juiceBtn")
        var nojuiceChked = inIntent.getStringExtra("nojuiceBtn")

        title = "메추리"
        returnBtn = findViewById<Button>(R.id.returnbtn)

        Btn1 = findViewById(R.id.btn1)
        Btn2 = findViewById(R.id.btn2)
        Btn3 = findViewById(R.id.btn3)
        Btn4 = findViewById(R.id.btn4)
        returnBtn.setOnClickListener {


            if(mealChked.isNullOrEmpty()){

                if(juiceChked.isNullOrEmpty()){
                    val intent = Intent(this, NoJuiceActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
                else if(nojuiceChked.isNullOrEmpty()){
                    val intent = Intent(this, JuiceActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }

            }

            else {
                val intent = Intent(this, SoupActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        }

        Btn1.setOnClickListener{
            val intent = Intent(this, MenuInfo::class.java)
            startActivity(intent)

        }

        Btn2.setOnClickListener{
            val intent = Intent(this, MenuInfo2::class.java)
            startActivity(intent)
        }
        Btn3.setOnClickListener{
            val intent = Intent(this, MenuInfo3::class.java)
            startActivity(intent)
        }
        Btn4.setOnClickListener{
            val intent = Intent(this, MenuInfo4::class.java)
            startActivity(intent)
        }

    }
}

