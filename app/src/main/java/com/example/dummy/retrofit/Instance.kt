package com.example.dummy.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//object Instance {
//
//    fun countryInstance(): Retrofit {
//        val logging = HttpLoggingInterceptor()
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//        val client = OkHttpClient.Builder()
//            .addInterceptor(logging)
//            .build()
//        return Retrofit.Builder().baseUrl("https://sibyl.ventureby.com/public/api/v1/")
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//}

object RetrofitClient {
    private const val BASE_URL = "https://sibyl.ventureby.com/public/api/v1/"

    val countryApi: API by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }
}