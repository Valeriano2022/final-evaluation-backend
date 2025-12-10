package com.example.final_evaluation_backend.dto.activity_type

import jakarta.validation.constraints.NotBlank

data class ActivityTypeRequest(
    @NotBlank
    val activityName: String,
    val description: String? = null
)