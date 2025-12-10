package com.example.final_evaluation_backend.model

import jakarta.persistence.*

@Entity
@Table(name = "activity_types")
data class ActivityType(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "activity_name")
    var name: String,

    @Column(nullable = true)
    var description: String? = null,
): BaseEntity()
