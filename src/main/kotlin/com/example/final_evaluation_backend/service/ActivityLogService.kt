package com.example.final_evaluation_backend.service

import com.example.final_evaluation_backend.dto.activity_log.ActivityLogRequest
import com.example.final_evaluation_backend.dto.activity_log.ActivityLogResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.time.LocalDate

interface ActivityLogService {

    fun create(userId: Long, request: ActivityLogRequest): ActivityLogResponse

    fun update(userId: Long, id: Long, request: ActivityLogRequest): ActivityLogResponse

    fun getById(userId: Long, id: Long): ActivityLogResponse

    fun delete(userId: Long, id: Long)

    fun getLogs(userId: Long, pageable: Pageable): Page<ActivityLogResponse>
}