package com.example.final_evaluation_backend.service

import com.example.final_evaluation_backend.dto.activity_log.ActivityLogRequest
import com.example.final_evaluation_backend.dto.activity_log.ActivityLogResponse
import com.example.final_evaluation_backend.exception.ActivityLogNotFoundException
import com.example.final_evaluation_backend.exception.ActivityTypeNotFoundException
import com.example.final_evaluation_backend.exception.UnauthorizedOperationException
import com.example.final_evaluation_backend.mapper.ActivityLogMapper
import com.example.final_evaluation_backend.mapper.ActivityLogMapper.toResponseDTO
import com.example.final_evaluation_backend.repository.ActivityLogRepository
import com.example.final_evaluation_backend.repository.ActivityTypeRepository
import com.example.final_evaluation_backend.repository.UserRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.time.LocalDate
import java.time.LocalDateTime

class ActivityLogServiceImpl(
    private val activityLogRepository: ActivityLogRepository,
    private val userRepository: UserRepository,
    private val activityTypeRepository: ActivityTypeRepository,
) : ActivityLogService {
    override fun create(
        userId: Long,
        request: ActivityLogRequest
    ): ActivityLogResponse {
        val user = validateUser(userId)
        val activityType = activityTypeRepository.findById(request.activityTypeId)
            .orElseThrow { ActivityTypeNotFoundException(request.activityTypeId) }

        return activityLogRepository.save(ActivityLogMapper
            .toEntity(user, activityType, request))
            .toResponseDTO()
    }

    override fun update(userId: Long, id: Long, request: ActivityLogRequest): ActivityLogResponse {
        val user = validateUser(userId)
        val log = activityLogRepository.findById(id)
            .orElseThrow { ActivityLogNotFoundException() }

        if (log.student.id != user.id) {
            throw UnauthorizedOperationException("Unauthorized")
        }

        val activityType = activityTypeRepository.findById(request.activityTypeId)
            .orElseThrow { ActivityTypeNotFoundException(request.activityTypeId) }

        log.activityType = activityType
        log.title = request.title
        log.description = request.description
        log.durationMinutes = request.durationMinutes
        log.date = request.date
        log.startTime = request.startTime
        log.endTime = request.endTime

        return activityLogRepository.save(log).toResponseDTO()
    }

    override fun getById(
        userId: Long,
        id: Long
    ): ActivityLogResponse {
        val user = validateUser(userId)

        val entity = activityLogRepository.findById(id)
            .orElseThrow { ActivityLogNotFoundException() }

        if (entity.student.id != user.id) {
            throw UnauthorizedOperationException("Unauthorized")
        }

        return entity.toResponseDTO()
    }

    override fun delete(userId: Long, id: Long) {
        val user = validateUser(userId)

        val log = activityLogRepository.findById(id)
            .orElseThrow { ActivityLogNotFoundException() }

        if (log.student.id != user.id) {
            throw UnauthorizedOperationException("Unauthorized")
        }

        activityLogRepository.delete(log)
    }

    override fun getLogs(
        userId: Long,
        pageable: Pageable
    ): Page<ActivityLogResponse> {
        validateUser(userId)
        return activityLogRepository.findByStudentId(userId, pageable)
            .map { it.toResponseDTO() }
    }


    private fun validateUser(userId: Long) =
        userRepository.findById(userId)
            .orElseThrow { UnauthorizedOperationException("Unauthorized") }
}