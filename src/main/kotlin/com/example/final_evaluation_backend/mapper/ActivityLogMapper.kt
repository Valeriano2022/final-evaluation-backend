package com.example.final_evaluation_backend.mapper

import com.example.final_evaluation_backend.dto.activity_log.ActivityLogRequest
import com.example.final_evaluation_backend.dto.activity_log.ActivityLogResponse
import com.example.final_evaluation_backend.model.ActivityLog
import com.example.final_evaluation_backend.model.ActivityType
import com.example.final_evaluation_backend.model.User

object ActivityLogMapper {
    fun ActivityLog.toResponseDTO(): ActivityLogResponse =
        ActivityLogResponse(
            id = this.id,
            activityTypeId = this.activityType.id,
            activityTypeName = this.activityType.name,
            title = this.title,
            description = this.description,
            durationMinutes = this.durationMinutes,
            date = this.date,
            startTime = this.startTime,
            endTime = this.endTime,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt
        )

    fun toEntity(user: User, activityType: ActivityType, request: ActivityLogRequest): ActivityLog =
    ActivityLog(
        student = user,
        activityType = activityType,
        title = request.title,
        description = request.description,
        durationMinutes = request.durationMinutes,
        date = request.date,
        startTime = request.startTime,
        endTime = request.endTime
    )
}