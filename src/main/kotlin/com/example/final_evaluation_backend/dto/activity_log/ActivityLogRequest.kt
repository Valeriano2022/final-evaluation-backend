package com.example.final_evaluation_backend.dto.activity_log

import java.time.LocalDate
import java.time.LocalTime


data class ActivityLogRequest(
    val studentId: Long,
    val activityTypeId: Long,
    val title: String? = null,
    val description: String,
    val durationMinutes: Int? = null,
    val date: LocalDate,
    val startTime: LocalTime? = null,
    val endTime: LocalTime? = null
)