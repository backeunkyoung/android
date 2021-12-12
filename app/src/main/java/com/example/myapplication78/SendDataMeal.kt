package com.example.myapplication78

import com.example.loaddb.GetDataList
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SendDataMeal {

    @FormUrlEncoded // 인코딩 옵션
    @POST("/meal")  // post 방식으로 전송, root경로를 제외한 경로를 적어줌
    fun requestData(
        @Field("type") type : String,
        @Field("spicy") spicy : String,
        @Field("soup") soup : String,
    ): Call<GetDataList>    // 응답으로 어떤 값을 받아올지

}