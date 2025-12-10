package com.example.final_evaluation_backend.dto.activity_log

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

data class ActivityLogResponse(
    val id: Long,
    val studentId: Long,
    val activityTypeId: Long,
    val activityTypeName: String,
    val title: String?,
    val description: String,
    val durationMinutes: Int?,
    val date: LocalDate,
    val startTime: LocalTime?,
    val endTime: LocalTime?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)