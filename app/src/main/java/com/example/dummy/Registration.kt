package com.example.dummy

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.example.dummy.databinding.FragmentRegistrationBinding
import java.util.regex.Pattern

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Registration.newInstance] factory method to
 * create an instance of this fragment.
 */
class Registration : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
//    lateinit var arrayAdapter: ArrayAdapter<Spinner>
    lateinit var binding: FragmentRegistrationBinding
//    var arrayAdapter : ArrayAdapter<>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(layoutInflater)

        binding.btn.setOnClickListener {
            submitForm()
        }
        emailFocusListener()

//        val spinner: Spinner = findViewById(R.id.countrySpinner)
        val countries = arrayOf("+1","+41","+91")
        val arrayAdapter = ArrayAdapter(requireActivity(),android.R.layout.simple_spinner_dropdown_item, countries)
        binding.countrySpinner.adapter = arrayAdapter


        return binding.root
    }

//    private fun validations(){
//        if (binding.etName.text.isNullOrEmpty()){
//            binding.etName.error = "Enter name"
//        }
//        else if (binding.etEmail.text.isNullOrEmpty()){
//            binding.etEmail.error = "Enter email"
//        }
//        else if (binding.etPhone.text.isNullOrEmpty()){
//            binding.etPhone.error = "Enter phone"
//        }
//        else{
//            findNavController().navigate(R.id.login)
//
//        }
//    }

    private fun submitForm()
    {
        binding.emailContainer.helperText = validEmail()
//        binding.passwordContainer.helperText = validPassword()
//        binding.phoneContainer.helperText = validPhone()

        val validEmail = binding.emailContainer.helperText == null
//        val validPassword = binding.passwordContainer.helperText == null
//        val validPhone = binding.phoneContainer.helperText == null

        if (validEmail )
            resetForm()
        else
            invalidForm()
    }

    private fun invalidForm()
    {
        var message = ""
        if(binding.emailContainer.helperText != null)
            message += "\n\nEmail: " + binding.emailContainer.helperText
//        if(binding.passwordContainer.helperText != null)
//            message += "\n\nPassword: " + binding.passwordContainer.helperText
//        if(binding.phoneContainer.helperText != null)
//            message += "\n\nPhone: " + binding.phoneContainer.helperText
    }

    private fun resetForm()
    {
        var message = "Email: " + binding.etEmail.text
//        message += "\nPassword: " + binding.passwordEditText.text
//        message += "\nPhone: " + binding.phoneEditText.text
//        AlertDialog.Builder(this)
//            .setTitle("Form submitted")
//            .setMessage(message)
//            .setPositiveButton("Okay"){ _,_ ->
//                binding.emailEditText.text = null
//                binding.passwordEditText.text = null
//                binding.phoneEditText.text = null
//
//                binding.emailContainer.helperText = getString(R.string.required)
//                binding.passwordContainer.helperText = getString(R.string.required)
//                binding.phoneContainer.helperText = getString(R.string.required)
//            }
//            .show()
    }

    private fun emailFocusListener()
    {
        binding.etEmail.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String?
    {
        val emailText = binding.etEmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "Invalid Email Address"
        }
        return null
    }

//    private fun passwordFocusListener()
//    {
//        binding.passwordEditText.setOnFocusChangeListener { _, focused ->
//            if(!focused)
//            {
//                binding.passwordContainer.helperText = validPassword()
//            }
//        }
//    }
//
//    private fun validPassword(): String?
//    {
//        val passwordText = binding.passwordEditText.text.toString()
//        if(passwordText.length < 8)
//        {
//            return "Minimum 8 Character Password"
//        }
//        if(!passwordText.matches(".*[A-Z].*".toRegex()))
//        {
//            return "Must Contain 1 Upper-case Character"
//        }
//        if(!passwordText.matches(".*[a-z].*".toRegex()))
//        {
//            return "Must Contain 1 Lower-case Character"
//        }
//        if(!passwordText.matches(".*[@#\$%^&+=].*".toRegex()))
//        {
//            return "Must Contain 1 Special Character (@#\$%^&+=)"
//        }
//
//        return null
//    }
//
//    private fun phoneFocusListener()
//    {
//        binding.phoneEditText.setOnFocusChangeListener { _, focused ->
//            if(!focused)
//            {
//                binding.phoneContainer.helperText = validPhone()
//            }
//        }
//    }
//
//    private fun validPhone(): String?
//    {
//        val phoneText = binding.phoneEditText.text.toString()
//        if(!phoneText.matches(".*[0-9].*".toRegex()))
//        {
//            return "Must be all Digits"
//        }
//        if(phoneText.length != 10)
//        {
//            return "Must be 10 Digits"
//        }
//        return null
//    }


//    data class Country(val name: String, val code: String){
//        val countries = listOf(
//            Country("United States", "+1"),
//            Country("United Kingdom", "+44"),
//            Country("India", "+91")
//            // Add more countries as needed
//        )
//        val spinner: Spinner = findViewById(R.id.countrySpinner)


    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Registration.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                Registration().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}