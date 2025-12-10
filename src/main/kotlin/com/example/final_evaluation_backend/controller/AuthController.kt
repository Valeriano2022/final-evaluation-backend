package com.example.final_evaluation_backend.controller

import com.example.final_evaluation_backend.dto.auth.LoginRequest
import com.example.final_evaluation_backend.dto.auth.LoginResponse
import com.example.final_evaluation_backend.dto.auth.RegisterRequest
import com.example.final_evaluation_backend.dto.auth.RegisterResponse
import com.example.final_evaluation_backend.dto.auth.TokenResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity

interface AuthController {
    fun registerUser(request: RegisterRequest): ResponseEntity<RegisterResponse>
    fun loginUser(request: LoginRequest, response: HttpServletResponse):  ResponseEntity<LoginResponse>
    fun logout(request: HttpServletRequest, response: HttpServletResponse): ResponseEntity<Unit>
    fun refresh(request: HttpServletRequest, response: HttpServletResponse):  ResponseEntity<TokenResponse>
}