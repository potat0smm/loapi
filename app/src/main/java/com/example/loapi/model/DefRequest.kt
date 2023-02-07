package com.example.loapi.model

data class DefRequest(
    val login: String,
    val password: String,
    val idRole: Int
)

data class Response(
    val token: String
)