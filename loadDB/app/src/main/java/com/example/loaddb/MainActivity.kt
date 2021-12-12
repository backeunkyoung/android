package com.example.loaddb

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var data:GetDataList? = null

    lateinit var meal : Button
    lateinit var drink : Button
    lateinit var food : Button
    lateinit var view01 : TextView

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // retrofit 객체 만들기
        var retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3333")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var sendData : SendData = retrofit.create(SendData::class.java)

        meal = findViewById<Button>(R.id.mealBtn)
        drink = findViewById<Button>(R.id.drinkBtn)
        food = findViewById<Button>(R.id.foodBtn)

        var mainType = "meal"
        var type = "Noodle"
        var spicy = "NOT_SPICY"
        var soup = "NOT_SOUP"

        meal.setOnClickListener{

            // SendData.kt에서 선언한 requestData 함수를 사용
            // 입력값 부분 : requestData()
            // 출력값 부분 : Callback<>
            sendData.requestData(mainType, type, spicy, soup).enqueue(object: Callback<GetDataList> {
                // 실패한 경우
                override fun onFailure(call: Call<GetDataList>, t: Throwable) {
                    Toast.makeText(applicationContext,"통신 실패 : " + t.message, Toast.LENGTH_SHORT).show()
                }

                // 성공한 경우
                override fun onResponse(call: Call<GetDataList>, response: Response<GetDataList>) {
                    view01 = findViewById<TextView>(R.id.view01)
                    view01.setText(data?.foodName)
                }
            })

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://10.0.2.2:3333/meal"))
            startActivity(intent)
        }

        drink.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://10.0.2.2:3333/dessertDrink"))
            startActivity(intent)
        }

        food.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://10.0.2.2:3333/dessertFood"))
            startActivity(intent)
        }
    }
}

