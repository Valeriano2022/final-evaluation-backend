package com.example.final_evaluation_backend.mapper

import com.example.final_evaluation_backend.dto.auth.TokenResponse
import org.springframework.stereotype.Component

@Component
object TokenMapper {
    fun toResponse(accessToken: String): TokenResponse =
        TokenResponse(
            accessToken = accessToken
        )
}