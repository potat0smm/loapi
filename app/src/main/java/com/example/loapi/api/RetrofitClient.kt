package com.example.loapi.api

import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.144.16/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: Api
        get() = retrofit.create(Api::class.java)
}
