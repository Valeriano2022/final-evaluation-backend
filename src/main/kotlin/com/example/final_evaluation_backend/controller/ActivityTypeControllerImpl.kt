package com.example.final_evaluation_backend.controller

import com.example.final_evaluation_backend.dto.activity_type.ActivityTypeRequest
import com.example.final_evaluation_backend.dto.activity_type.ActivityTypeResponse
import com.example.final_evaluation_backend.exception.UnauthorizedOperationException
import com.example.final_evaluation_backend.security.CustomUserPrincipal
import com.example.final_evaluation_backend.service.ActivityTypeService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.function.EntityResponse

@RestController
@RequestMapping("/api/activity-types")
class ActivityTypeControllerImpl(
    private val activityTypeService: ActivityTypeService
): ActivityTypeController {
    @PostMapping
    override fun create(
        authentication: Authentication?,
        @Valid @RequestBody request: ActivityTypeRequest
    ): ResponseEntity<ActivityTypeResponse>{
        val principal = authentication?.principal
                as? CustomUserPrincipal
            ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        val created = activityTypeService.create(principal.userId, request)
        return ResponseEntity.status(HttpStatus.CREATED).body(created)
    }
    @PutMapping("/{id}")
    override fun update(
        authentication: Authentication?,
        @PathVariable id: Long,
        @Valid @RequestBody request: ActivityTypeRequest
    ): ResponseEntity<ActivityTypeResponse>{
        val principal = authentication?.principal
                as? CustomUserPrincipal
            ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        val updated = activityTypeService.update(principal.userId, id,request)
        return ResponseEntity.status(HttpStatus.OK).body(updated)
    }
    @GetMapping("/{id}")
    override fun getById(
        id: Long
    ): ResponseEntity<ActivityTypeResponse> {
        val type = activityTypeService.getById(id)
        return ResponseEntity.status(HttpStatus.OK).body(type)
    }
    @GetMapping
    override fun getAll(): ResponseEntity<List<ActivityTypeResponse>> {
        val type = activityTypeService.getAll()
        return ResponseEntity.status(HttpStatus.OK).body(type)
    }
    @DeleteMapping("/{id}")
    override fun delete(authentication: Authentication?, @PathVariable id: Long): ResponseEntity<Unit> {
        val principal = authentication?.principal
                as? CustomUserPrincipal
            ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        activityTypeService.delete(principal.userId, id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

}