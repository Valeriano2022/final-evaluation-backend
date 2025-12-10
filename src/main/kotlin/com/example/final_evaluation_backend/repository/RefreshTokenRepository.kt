package com.example.final_evaluation_backend.repository

import com.example.final_evaluation_backend.model.RefreshToken
import com.example.final_evaluation_backend.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : JpaRepository<RefreshToken, Long> {
    fun findByToken(token: String): RefreshToken?
    fun findAllByUserAndExpiredIsFalseAndRevokedIsFalse(user: User): List<RefreshToken>
    fun existsByToken(token: String): Boolean?
}