package com.example.loaddb

data class GetDataList (
    var products : List<GetData>
)

data class GetData(
    var food_id : Int,
    var food_name : String,
    var type : String,
    var menu_explain : String,
    var thumbnail_picture : String
)