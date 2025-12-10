package com.example.final_evaluation_backend.service

import com.example.final_evaluation_backend.dto.auth.LoginRequest
import com.example.final_evaluation_backend.dto.auth.LoginResponse
import com.example.final_evaluation_backend.dto.auth.RegisterRequest
import com.example.final_evaluation_backend.dto.auth.RegisterResponse
import com.example.final_evaluation_backend.dto.auth.TokenResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

interface AuthService {
    fun register(request: RegisterRequest): RegisterResponse
    fun login(request: LoginRequest, response: HttpServletResponse): LoginResponse
    fun logout(request: HttpServletRequest, response: HttpServletResponse)
    fun refresh(request: HttpServletRequest, response: HttpServletResponse) : TokenResponse
}