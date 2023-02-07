package com.example.loapi.api

import com.example.loapi.model.DefRequest
import com.example.loapi.model.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
//import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @POST("register")
    fun register(@Body body: DefRequest):Call<Response>


}