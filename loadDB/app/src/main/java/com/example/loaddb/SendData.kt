package com.example.loaddb

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SendData {

    @FormUrlEncoded // 인코딩 옵션
    @POST("/meal")  // post 방식으로 전송, root경로를 제외한 경로를 적어줌
    fun requestData(
        @Field("mainType") mainType : String,
        @Field("type") type : String,
        @Field("spicy") spicy : String,
        @Field("soup") soup : String,
    ): retrofit2.Call<GetDataList>    // 응답으로 어떤 값을 받아올지
}