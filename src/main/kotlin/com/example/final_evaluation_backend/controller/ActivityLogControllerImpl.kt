package com.example.final_evaluation_backend.controller

import com.example.final_evaluation_backend.dto.activity_log.ActivityLogRequest
import com.example.final_evaluation_backend.dto.activity_log.ActivityLogResponse
import com.example.final_evaluation_backend.security.CustomUserPrincipal
import com.example.final_evaluation_backend.service.ActivityLogService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/activity-logs")
class ActivityLogControllerImpl(
    private val activityLogService: ActivityLogService
) : ActivityLogController {

    override fun create(
        authentication: Authentication,
        @RequestBody request: ActivityLogRequest
    ): ResponseEntity<ActivityLogResponse> {

        val principal = authentication.principal as? CustomUserPrincipal
            ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()

        val response = activityLogService.create(principal.userId, request)

        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    override fun update(
        authentication: Authentication,
        @PathVariable id: Long,
        @RequestBody request: ActivityLogRequest
    ): ResponseEntity<ActivityLogResponse> {

        val principal = authentication.principal as? CustomUserPrincipal
            ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()

        val response = activityLogService.update(principal.userId, id, request)

        return ResponseEntity.ok(response)
    }

    override fun getById(
        authentication: Authentication,
        @PathVariable id: Long
    ): ResponseEntity<ActivityLogResponse> {

        val principal = authentication.principal as? CustomUserPrincipal
            ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()

        val response = activityLogService.getById(principal.userId, id)

        return ResponseEntity.ok(response)
    }

    override fun delete(
        authentication: Authentication,
        @PathVariable id: Long
    ) {
        val principal = authentication.principal as? CustomUserPrincipal
            ?: throw RuntimeException("Unauthorized")

        activityLogService.delete(principal.userId, id)
    }

    override fun getLogs(
        authentication: Authentication,
        pageable: Pageable
    ): ResponseEntity<Page<ActivityLogResponse>> {

        val principal = authentication.principal as? CustomUserPrincipal
            ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()

        val response = activityLogService.getLogs(principal.userId, pageable)

        return ResponseEntity.ok(response)
    }
}
