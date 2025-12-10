package com.example.final_evaluation_backend.dto.activity_type

data class ActivityTypeRequest(
    val activityName: String,
    val description: String? = null
)