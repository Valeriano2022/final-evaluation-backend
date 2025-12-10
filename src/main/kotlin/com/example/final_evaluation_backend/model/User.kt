package com.example.final_evaluation_backend.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "name")
    val name: String,

    @Column(unique = true)
    val email: String,

    @Column(name = "password_hashed")
    val password: String
) : BaseEntity()
