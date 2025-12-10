package com.example.final_evaluation_backend.dto.activity_type

import java.time.LocalDateTime

data class ActivityTypeResponse(
    val id: Long,
    val activityName: String,
    val description: String?,
    val createAt: LocalDateTime
)