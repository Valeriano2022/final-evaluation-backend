package com.example.final_evaluation_backend.mapper

import com.example.final_evaluation_backend.model.User
import com.example.final_evaluation_backend.dto.auth.LoginResponse
import com.example.final_evaluation_backend.dto.auth.RegisterRequest
import com.example.final_evaluation_backend.dto.auth.RegisterResponse
import com.example.final_evaluation_backend.dto.auth.UserResponse
import org.springframework.stereotype.Component

@Component
object UserMapper {

    fun toResponse(user: User) = RegisterResponse(
        user = UserResponse(
            id = user.id,
            email = user.email,
            name = user.name,
        ),
    )

    fun RegisterRequest.toEntity() = User(
        name = this.name,
        email = this.email,
        password = this.password
    )

    fun toResponse(accessToken: String, user: User) = LoginResponse(
        accessToken = accessToken,
        user = UserResponse(
            id = user.id,
            name = user.name,
            email = user.email
        )
    )
}