package com.example.dummy

import android.R
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummy.adapter.CountryAdapter
import com.example.dummy.adapter.CountryApiHelper
import com.example.dummy.databinding.FragmentLoginBinding
import com.example.dummy.models.ApiResponse
import com.example.dummy.models.Response
import com.example.dummy.retrofit.API
import com.example.dummy.retrofit.RetrofitClient
import com.example.dummy.retrofit.RetrofitClient.countryApi
import retrofit2.Call
import retrofit2.Callback

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Login.newInstance] factory method to
 * create an instance of this fragment.
 */
class Login : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentLoginBinding
    lateinit var countryAdapter: CountryAdapter
//    var studentList=ArrayList<Response>()
//    var showUserList=ArrayList<Response>()
    var arrayList = ArrayList<Response>()
//    private lateinit var countryApiHelper: CountryApiHelper

    val api = RetrofitClient.countryApi
    val call = countryApi.countryName("Bearer 21|LBuf4K0GuIQpIqSps8PFevJnUPOZlLThX280ZbAdd6800d6e")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
//        countryApiHelper = CountryApiHelper(this)
//        countryApiHelper.getCountries()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)



        countryAdapter = CountryAdapter(arrayList)
//        binding.country.layoutManager = LinearLayoutManager(requireActivity())
//
//        binding.country.adapter = countryAdapter

//        return inflater.inflate(R.layout.fragment_login, container, false)


//        Instance.countryInstance().create(API::class.java).countryName("Bearer 21|LBuf4K0GuIQpIqSps8PFevJnUPOZlLThX280ZbAdd6800d6e")
//            .enqueue(object : Callback<ApiResponse?>{
//                override fun onResponse(
//                    call: Call<ApiResponse?>,
//                    response: retrofit2.Response<ApiResponse?>,
//                ) {
//                    val res = response.body()
//                    Log.d("TAG--->", response.body()?.data.toString())
//                    arrayList.addAll(response.body()?.data ?: arrayListOf())
//                    countryAdapter.notifyDataSetChanged()
//                }
//
//                override fun onFailure(call: Call<ApiResponse?>, t: Throwable) {
//                    Log.d("TAG--->",t.message.toString())
//                }
//
//            })

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(
                call: Call<ApiResponse>,
                response: retrofit2.Response<ApiResponse>,
            ) {
                if (response.isSuccessful) {
                    val countries = response.body()
                    countries?.let {
                        populateCountrySpinner(listOf(it))
                    }
                } else {
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })



        return binding.root
    }

    private fun populateCountrySpinner(countries: List<ApiResponse>) {
        val countryNames = countries.map { it.data }
        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_dropdown_item, countryNames)
        binding.countrySpinner.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Login.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Login().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

//    override fun onCountriesLoaded(countries: List<ApiResponse>) {
//        val countryNames = countries.map { it.data }
//        val adapter = ArrayAdapter(requireActivity(), R.layout.simple_spinner_dropdown_item, countryNames)
//        binding.countrySpinner.adapter = adapter
//    }
//
//    override fun onError(error: String) {
//
//    }
//}