package com.example.myapplication78

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var startBtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn = findViewById<Button>(R.id.startbtn)

        title = "메추리"

        startBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.addFlags( FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

    }



}