package com.example.final_evaluation_backend.dto.activity_type

data class ActivityTypeResponse(
    val id: Long,
    val activityName: String,
    val description: String?
)