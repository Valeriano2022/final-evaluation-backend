package com.example.final_evaluation_backend.dto.auth


data class LoginResponse(
    val accessToken: String,
    val user: UserResponse
)
