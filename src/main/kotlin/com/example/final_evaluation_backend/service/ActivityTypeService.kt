package com.example.final_evaluation_backend.service

import com.example.final_evaluation_backend.dto.activity_type.ActivityTypeRequest
import com.example.final_evaluation_backend.dto.activity_type.ActivityTypeResponse

interface ActivityTypeService {
    fun create(userId: Long, request: ActivityTypeRequest): ActivityTypeResponse

    fun update(userId: Long,id: Long, request: ActivityTypeRequest): ActivityTypeResponse

    fun getById(id: Long): ActivityTypeResponse

    fun getAll(): List<ActivityTypeResponse>

    fun delete(userId: Long, id: Long)
}