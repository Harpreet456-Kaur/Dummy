package com.example.dummy.adapter

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.dummy.models.ApiResponse
import com.google.gson.Gson

class CountryApiHelper(private val listener: CountryApiListener) {

    interface CountryApiListener {
        fun onCountriesLoaded(countries: List<ApiResponse>)
        fun onError(error: String)
    }

    fun getCountries() {
        val url = "https://sibyl.ventureby.com/public/api/v1/country"

        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                val countries = Gson().fromJson(response.toString(), Array<ApiResponse>::class.java).toList()
                listener.onCountriesLoaded(countries)
            },
            Response.ErrorListener { error ->
                listener.onError(error.message ?: "An error occurred")
            })

        Volley.newRequestQueue(MyApp.instance).add(request)
    }
}