package com.example.final_evaluation_backend.controller

import com.example.final_evaluation_backend.dto.activity_type.ActivityTypeRequest
import com.example.final_evaluation_backend.dto.activity_type.ActivityTypeResponse
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication

interface ActivityTypeController {
    fun create(authentication: Authentication?, request: ActivityTypeRequest): ResponseEntity<ActivityTypeResponse>

    fun update(authentication: Authentication?, id: Long, request: ActivityTypeRequest): ResponseEntity<ActivityTypeResponse>

    fun getById(id: Long): ResponseEntity<ActivityTypeResponse>

    fun getAll():  ResponseEntity<List<ActivityTypeResponse>>

    fun delete(authentication: Authentication?, id: Long): ResponseEntity<Unit>
}