package com.example.loapi.api

import okhttp3.*


object RetrofitClient {
    class Get(s: String) {

    }

    public fun get(path: String): Response {
        var client = OkHttpClient().newBuilder()
            .build()
        var request: Request = Request.Builder()
            .url("http://192.168.144.16/api/${path}")
            .method("GET", null)
            .addHeader("Content-Type", "application/json")
            .build()
        var response = client.newCall(request).execute()

        return response
    }
}
