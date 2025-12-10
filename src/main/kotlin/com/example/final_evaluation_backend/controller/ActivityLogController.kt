package com.example.final_evaluation_backend.controller

import com.example.final_evaluation_backend.dto.activity_log.ActivityLogRequest
import com.example.final_evaluation_backend.dto.activity_log.ActivityLogResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication

interface ActivityLogController {

    fun create(
        authentication: Authentication,
        request: ActivityLogRequest
    ): ResponseEntity<ActivityLogResponse>

    fun update(
        authentication: Authentication,
        id: Long,
        request: ActivityLogRequest
    ): ResponseEntity<ActivityLogResponse>

    fun getById(
        authentication: Authentication,
        id: Long
    ): ResponseEntity<ActivityLogResponse>

    fun delete(
        authentication: Authentication,
        id: Long
    )

    fun getLogs(
        authentication: Authentication,
        pageable: Pageable
    ): ResponseEntity<Page<ActivityLogResponse>>

}
