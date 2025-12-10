package com.example.final_evaluation_backend.repository

import com.example.final_evaluation_backend.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>{
    fun findByEmail(email: String): User?
    fun existsByEmail(email: String): Boolean
}