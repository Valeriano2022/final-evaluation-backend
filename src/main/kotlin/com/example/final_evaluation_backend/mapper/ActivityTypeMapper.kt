package com.example.final_evaluation_backend.mapper

import com.example.final_evaluation_backend.dto.activity_type.ActivityTypeResponse
import com.example.final_evaluation_backend.model.ActivityType
import org.springframework.stereotype.Component

@Component
object ActivityTypeMapper {
    fun ActivityType.toResponseDTO(): ActivityTypeResponse =
        ActivityTypeResponse(
            id = this.id,
            activityName = this.name,
            description = this.description,
            createAt = this.createdAt
        )
}