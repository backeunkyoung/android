package com.example.myapplication78

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
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

        var menu1_name : String = ""
        var menu2_name : String = ""
        var menu3_name : String = ""
        var menu4_name : String = ""

        var menu1_img : String = ""
        var menu2_img : String = ""
        var menu3_img : String = ""
        var menu4_img : String = ""

        var menu_img : ArrayList<String>

        var explain1 : String = ""
        var explain2 : String = ""
        var explain3 : String = ""
        var explain4 : String = ""

        var explain : ArrayList<String>


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

                                menu1_name = arr!!.products.get(0).food_name
                                menu2_name = arr!!.products.get(1).food_name
                                menu3_name = arr!!.products.get(2).food_name
                                menu4_name = arr!!.products.get(3).food_name

                                Btn1.setText(menu1_name)
                                Btn2.setText(menu2_name)
                                Btn3.setText(menu3_name)
                                Btn4.setText(menu4_name)

                                menu1_img = arr!!.products.get(0).thumbnail_picture
                                menu2_img = arr!!.products.get(1).thumbnail_picture
                                menu3_img = arr!!.products.get(2).thumbnail_picture
                                menu4_img = arr!!.products.get(3).thumbnail_picture

                                explain1 = arr!!.products.get(0).menu_explain
                                explain2 = arr!!.products.get(1).menu_explain
                                explain3 = arr!!.products.get(2).menu_explain
                                explain4 = arr!!.products.get(3).menu_explain


                                Glide.with(this@MenuList)
                                    .load(arr!!.products.get(0).thumbnail_picture)
                                    .into(findViewById(R.id.imageView1))

                                Glide.with(this@MenuList)
                                    .load(arr!!.products.get(1).thumbnail_picture)
                                    .into(findViewById(R.id.imageView2))

                                Glide.with(this@MenuList)
                                    .load(arr!!.products.get(2).thumbnail_picture)
                                    .into(findViewById(R.id.imageView3))

                                Glide.with(this@MenuList)
                                    .load(arr!!.products.get(3).thumbnail_picture)
                                    .into(findViewById(R.id.imageView4))


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

                        menu1_name = arr!!.products.get(0).food_name
                        menu2_name = arr!!.products.get(1).food_name
                        menu3_name = arr!!.products.get(2).food_name
                        menu4_name = arr!!.products.get(3).food_name

                        menu1_img = arr!!.products.get(0).thumbnail_picture
                        menu2_img = arr!!.products.get(1).thumbnail_picture
                        menu3_img = arr!!.products.get(2).thumbnail_picture
                        menu4_img = arr!!.products.get(3).thumbnail_picture

                        explain1 = arr!!.products.get(0).menu_explain
                        explain2 = arr!!.products.get(1).menu_explain
                        explain3 = arr!!.products.get(2).menu_explain
                        explain4 = arr!!.products.get(3).menu_explain




                        Btn1.setText(menu1_name)
                        Btn2.setText(menu2_name)
                        Btn3.setText(menu3_name)
                        Btn4.setText(menu4_name)

                        Glide.with(this@MenuList)
                            .load(arr!!.products.get(0).thumbnail_picture)
                            .into(findViewById(R.id.imageView1))

                        Glide.with(this@MenuList)
                            .load(arr!!.products.get(1).thumbnail_picture)
                            .into(findViewById(R.id.imageView2))

                        Glide.with(this@MenuList)
                            .load(arr!!.products.get(2).thumbnail_picture)
                            .into(findViewById(R.id.imageView3))

                        Glide.with(this@MenuList)
                            .load(arr!!.products.get(3).thumbnail_picture)
                            .into(findViewById(R.id.imageView4))


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

                        menu1_name = arr!!.products.get(0).food_name
                        menu2_name = arr!!.products.get(1).food_name
                        menu3_name = arr!!.products.get(2).food_name
                        menu4_name = arr!!.products.get(3).food_name

                        menu1_img = arr!!.products.get(0).thumbnail_picture
                        menu2_img = arr!!.products.get(1).thumbnail_picture
                        menu3_img = arr!!.products.get(2).thumbnail_picture
                        menu4_img = arr!!.products.get(3).thumbnail_picture

                        explain1 = arr!!.products.get(0).menu_explain
                        explain2 = arr!!.products.get(1).menu_explain
                        explain3 = arr!!.products.get(2).menu_explain
                        explain4 = arr!!.products.get(3).menu_explain

                        Btn1.setText(menu1_name)
                        Btn2.setText(menu2_name)
                        Btn3.setText(menu3_name)
                        Btn4.setText(menu4_name)

                        Glide.with(this@MenuList)
                            .load(arr!!.products.get(0).thumbnail_picture)
                            .into(findViewById(R.id.imageView1))

                        Glide.with(this@MenuList)
                            .load(arr!!.products.get(1).thumbnail_picture)
                            .into(findViewById(R.id.imageView2))

                        Glide.with(this@MenuList)
                            .load(arr!!.products.get(2).thumbnail_picture)
                            .into(findViewById(R.id.imageView3))

                        Glide.with(this@MenuList)
                            .load(arr!!.products.get(3).thumbnail_picture)
                            .into(findViewById(R.id.imageView4))


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

            super.onBackPressed()
        }



        Btn1.setOnClickListener{
            val intent = Intent(this, MenuInfo::class.java)
            intent.putExtra("menu_name", menu1_name)
            intent.putExtra("menu_img", menu1_img)
            intent.putExtra("explain", explain1)
            startActivity(intent)
        }
        Btn2.setOnClickListener{
            val intent = Intent(this, MenuInfo2::class.java)
            intent.putExtra("menu_name", menu2_name)
            intent.putExtra("menu_img", menu2_img)
            intent.putExtra("explain", explain2)
            startActivity(intent)
        }
        Btn3.setOnClickListener{
            val intent = Intent(this, MenuInfo3::class.java)
            intent.putExtra("menu_name", menu3_name)
            intent.putExtra("menu_img", menu3_img)
            intent.putExtra("explain", explain3)
            startActivity(intent)
        }
        Btn4.setOnClickListener{
            val intent = Intent(this, MenuInfo4::class.java)
            intent.putExtra("menu_name", menu4_name)
            intent.putExtra("menu_img", menu4_img)
            intent.putExtra("explain", explain4)

            startActivity(intent)
        }

    }


}

