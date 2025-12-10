package com.example.final_evaluation_backend.model

import jakarta.persistence.*

@Entity
@Table(name = "tokens")
data class RefreshToken(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Version
    var version: Long? = null,

    @Column(unique = true)
    var token: String,

    var expired: Boolean = false,
    var revoked: Boolean = false,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User
): BaseEntity()
