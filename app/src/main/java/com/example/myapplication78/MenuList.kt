package com.example.myapplication78

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.loaddb.GetDataList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.properties.Delegates


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
        var dessertChked = inIntent.getStringExtra("dessertBtn")

        // DB 종류
        var isMeal : Boolean = false
        var isJuice : Boolean = false
        var isNoJuice : Boolean = false
        if(mainChked != null){
            if(mainChked == "Meal"){
                isMeal = true
                isJuice = false
                isNoJuice = false
            }
            else{
                isMeal = false
            }
            if(mainChked == "Dessert"){
                if(dessertChked == "JUICE"){
                    isJuice = true
                    isNoJuice = false
                    isMeal = false
                }
                else if(dessertChked == "NO JUICE"){
                    isNoJuice = true
                    isJuice = false
                    isMeal = false
                }
                else{
                    isJuice = false
                    isNoJuice = false
                }
            }
        }

        // retrofit 객체 만들기
        var retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3333")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        if (isMeal) {
            // 이전 페이지들에서 받아온 type, spicy, soup 정보 => 반드시 DB에 정의된 값들이어야 함(server 쿼리문 때문)
            var type = mealChked
            var spicy = spicyChked
            var soup = soupChked

            Toast.makeText(getApplicationContext(), type +" "+ spicy +" "+ soup, Toast.LENGTH_LONG).show()

            var sendDataMeal : SendDataMeal = retrofit.create(SendDataMeal::class.java)

            // SendData.kt에서 선언한 requestData 함수를 사용
            // 입력값 부분 : requestData()
            // 출력값 부분 : Callback<>
            // REST (GET, POST, UPDATE, DELETE) 중에 POST 통신으로 데이터를 가져옴
            if (type != null && spicy != null && soup != null) {

                        sendDataMeal.requestData(type, spicy, soup).enqueue(object:
                            Callback<GetDataList> {
                            // 실패한 경우
                            override fun onFailure(call: Call<GetDataList>, t: Throwable) {
                                Toast.makeText(applicationContext,"통신 실패 : " + t.message, Toast.LENGTH_SHORT).show()
                            }


                            // 성공한 경우
                            override fun onResponse(call: Call<GetDataList>, response: Response<GetDataList>) {
                                //                    view01.setText(response.body()?.toString())
                                var arr = response.body()


                                var menu1 = arr?.products?.get(0)?.toString()
                                var menu2 = arr?.products?.get(1)?.toString()
                                var menu3 = arr?.products?.get(2)?.toString()
                                var menu4 = arr?.products?.get(3)?.toString()

                                System.out.println(menu1 + "\n" + menu2 + "\n" + menu3 + "\n" + menu4)

                                //                    System.out.println(arr?.toString())
                            }
                        })


            }
        }

        else if (isJuice) {

            // 이전 페이지들에서 받아온 is_caffeine 정보 => 반드시 DB에 정의된 값들이어야 함(server 쿼리문 때문)
            var is_caffeine = juiceChked

            var sendDataJuice : SendDataJuice = retrofit.create(SendDataJuice::class.java)

            Toast.makeText(getApplicationContext(), "isJuice: " + isJuice + is_caffeine, Toast.LENGTH_LONG).show()

            if (is_caffeine != null) {
                sendDataJuice.requestData(is_caffeine).enqueue(object:
                    Callback<GetDataList> {
                    // 실패한 경우
                    override fun onFailure(call: Call<GetDataList>, t: Throwable) {
                        Toast.makeText(applicationContext,"통신 실패 : " + t.message, Toast.LENGTH_SHORT).show()
                    }

                    // 성공한 경우
                    override fun onResponse(call: Call<GetDataList>, response: Response<GetDataList>) {
                        var arr = response.body()
                        System.out.println(arr?.toString())
                    }
                })
            }
        }
        else if (isNoJuice) {
            // 이전 페이지들에서 받아온 type 정보 => 반드시 DB에 정의된 값들이어야 함(server 쿼리문 때문)
            var type = nojuiceChked

            var sendDataNoJuice : SendDataNoJuice = retrofit.create(SendDataNoJuice::class.java)

            Toast.makeText(getApplicationContext(), "isNoJuice: " + isNoJuice + type, Toast.LENGTH_LONG).show()

            if (type != null) {
                sendDataNoJuice.requestData(type).enqueue(object:
                    Callback<GetDataList> {
                    // 실패한 경우
                    override fun onFailure(call: Call<GetDataList>, t: Throwable) {
                        Toast.makeText(applicationContext,"통신 실패 : " + t.message, Toast.LENGTH_SHORT).show()
                    }

                    // 성공한 경우
                    override fun onResponse(call: Call<GetDataList>, response: Response<GetDataList>) {
                        var arr = response.body()
                        System.out.println(arr?.toString())
                    }
                })
            }
        }


        title = "메추리"

        returnBtn = findViewById<Button>(R.id.returnbtn)
        Btn1 = findViewById(R.id.btn1)
        Btn2 = findViewById(R.id.btn2)
        Btn3 = findViewById(R.id.btn3)
        Btn4 = findViewById(R.id.btn4)

        returnBtn.setOnClickListener {

           /* if(mealChked.isNullOrEmpty()){
                if(juiceChked.isNullOrEmpty()){
                    super.onBackPressed()

                }
                else if(nojuiceChked.isNullOrEmpty()){
                    val intent = Intent(this, JuiceActivity::class.java)
                   intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)

                }
            }

            else {
                val intent = Intent(this, SoupActivity::class.java)
               intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }*/


            super.onBackPressed()
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

