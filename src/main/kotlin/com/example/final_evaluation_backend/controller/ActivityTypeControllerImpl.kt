package com.example.final_evaluation_backend.controller

import com.example.final_evaluation_backend.dto.activity_type.ActivityTypeRequest
import com.example.final_evaluation_backend.dto.activity_type.ActivityTypeResponse
import com.example.final_evaluation_backend.exception.UnauthorizedOperationException
import com.example.final_evaluation_backend.security.CustomUserPrincipal
import com.example.final_evaluation_backend.service.ActivityTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.servlet.function.EntityResponse

class ActivityTypeControllerImpl(
    private val activityTypeService: ActivityTypeService
): ActivityTypeController {
    override fun create(
        authentication: Authentication?,
        request: ActivityTypeRequest
    ): ResponseEntity<ActivityTypeResponse>{
        val principal = authentication?.principal
                as? CustomUserPrincipal
            ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        val created = activityTypeService.create(principal.userId, request)
        return ResponseEntity.status(HttpStatus.CREATED).body(created)
    }

    override fun update(
        authentication: Authentication?,
        id: Long,
        request: ActivityTypeRequest
    ): ResponseEntity<ActivityTypeResponse>{
        val principal = authentication?.principal
                as? CustomUserPrincipal
            ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        val updated = activityTypeService.update(principal.userId, id,request)
        return ResponseEntity.status(HttpStatus.OK).body(updated)
    }

    override fun getById(
        id: Long
    ): ResponseEntity<ActivityTypeResponse> {
        val type = activityTypeService.getById(id)
        return ResponseEntity.status(HttpStatus.OK).body(type)
    }

    override fun getAll(): ResponseEntity<List<ActivityTypeResponse>> {
        val type = activityTypeService.getAll()
        return ResponseEntity.status(HttpStatus.OK).body(type)
    }

    override fun delete(authentication: Authentication?, id: Long): ResponseEntity<Unit> {
        val principal = authentication?.principal
                as? CustomUserPrincipal
            ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        activityTypeService.delete(principal.userId, id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

}