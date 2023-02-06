package com.example.loapi.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.loapi.R
import com.example.loapi.api.RetrofitClient
import com.example.loapi.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonSignUp.setOnClickListener {

            val username = binding.username.text.toString().trim()
            val userpass = binding.userpass.text.toString().trim()
            val idRole = binding.idRole.text.toString().trim()

            if (username.isEmpty()) {
                binding.username.error = "no"
                binding.username.requestFocus()
                return@setOnClickListener
            }
            if (userpass.isEmpty()) {
                binding.userpass.error = "no"
                binding.userpass.requestFocus()
                return@setOnClickListener
            }
            if (idRole.isEmpty()) {
                binding.idRole.error = "no"
                binding.idRole.requestFocus()
                return@setOnClickListener
            }

            //Toast.makeText(applicationContext, "lol",Toast.LENGTH_LONG).show()

            Log.d("tag", RetrofitClient.Get("Users").toString())

                //RetrofitClient.get()


        }

    }
}