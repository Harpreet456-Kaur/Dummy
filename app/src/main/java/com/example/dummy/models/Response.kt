package com.example.dummy.models

data class Response(
    val id: Int? = null,
    val iso : String? = null,
    val name : String ? = null,
    val nicename : String? = null,
    val iso3 : String ? = null,
    val numcode : Int? = null,
    val phonecode : Int? = null
)

data class ApiResponse(
    var data : ArrayList<Response> = arrayListOf()
)