package com.example.myapplication78

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import com.bumptech.glide.Glide


class MenuInfo4: AppCompatActivity() {

    lateinit var returnBtn : Button
    lateinit var returnbtn : Button
    lateinit var kindText : TextView
    lateinit var explainText : TextView


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_info4)
        title = "메추리"
        returnbtn = findViewById(R.id.returnbtn)
        returnBtn = findViewById<Button>(R.id.returnBtn1)

        kindText = findViewById<TextView>(R.id.kinds)
        explainText = findViewById<TextView>(R.id.textView)

        var inIntent = intent
        var name = inIntent.getStringExtra("menu_name")
        var explain = inIntent.getStringExtra("explain")
        var img = inIntent.getStringExtra("menu_img")

        if(name.isNullOrEmpty()){
            name = ""
        }
        if(explain.isNullOrEmpty()){
            explain = ""
        }
        if(img.isNullOrEmpty()){
            img = ""
        }

        kindText.text = name
        explainText.text = explain
        Glide.with(this@MenuInfo4)
            .load(img)
            .into(findViewById(R.id.menuImg))


        returnbtn.setOnClickListener {
        /*    val intent = Intent(this, MenuList::class.java)
            startActivity(intent)*/
            super.onBackPressed()
        }

        returnBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }


    }
}

