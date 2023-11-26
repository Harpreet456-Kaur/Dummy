package com.example.dummy.retrofit

import com.example.dummy.models.ApiResponse
import com.example.dummy.models.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface API {

    @GET("country")
    fun countryName(@Header("authorization") token: String): Call<ApiResponse>
}