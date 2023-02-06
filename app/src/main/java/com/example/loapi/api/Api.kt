package com.example.loapi.api

import com.example.loapi.model.DefResponse
import retrofit2.Call
import retrofit2.http.Field
//import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    //@FormUrlEncoded
    @POST("createUser")

    fun createUser(
        @Field("username") username:String,
        @Field("userpass") userpass:String,
        @Field("idRole") idRole:Int
    ):Call<DefResponse>


}