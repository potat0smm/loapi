package com.example.loapi.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loapi.R
import com.example.loapi.api.RetrofitClient
import com.example.loapi.databinding.ActivityMainBinding
import com.example.loapi.databinding.FragmentBlankBinding
import com.example.loapi.model.DefRequest
import com.example.loapi.model.Response
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
import retrofit2.Call
import retrofit2.Callback
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonSignUp.setOnClickListener {

            val login = binding.username.text.toString().trim()
            val password = binding.userpass.text.toString().trim()
            val idRole = binding.idRole.text.toString().trim()

            if (login.isEmpty()) {
                binding.username.error = "no"
                binding.username.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.userpass.error = "no"
                binding.userpass.requestFocus()
                return@setOnClickListener
            }
            if (idRole.isEmpty()) {
                binding.idRole.error = "no"
                binding.idRole.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.service.register(DefRequest(login, password, 1))
                .enqueue(object : Callback<Response> {
                    override fun onResponse(
                        call: Call<Response>, response: retrofit2.Response<Response>
                    ) {
                        //Log.d("tag", response.toString())
                        Log.d("tag", response.body()!!.token)

                        Toast.makeText(this@MainActivity,"Login Successful",Toast.LENGTH_SHORT).show()

                        /*binding.buttonSignUp.setOnClickListener {
                            val intent = Intent(this@MainActivity,MainActivity2::class.java)
                            startActivity(intent)
                        }*/


                        /*fun goMy(@Suppress("UNUSED_PARAMETER")view: View){
                            val intent = Intent(this@MainActivity,MainActivity2::class.java)
                            startActivity(intent)
                        }*/

                    }

                    override fun onFailure(call: Call<Response>, t: Throwable) {
                        Log.d("tag", t.message.toString())
                    }
                })

        }


        //Toast.makeText(applicationContext, "lol",Toast.LENGTH_LONG).show()

        //Log.d("tag", RetrofitClient.Get("Users").toString())

        //RetrofitClient.get()


    }


}
