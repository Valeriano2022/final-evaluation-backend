package com.example.final_evaluation_backend.service

import com.example.final_evaluation_backend.dto.activity_type.ActivityTypeRequest
import com.example.final_evaluation_backend.dto.activity_type.ActivityTypeResponse
import com.example.final_evaluation_backend.exception.ActivityTypeAlreadyExists
import com.example.final_evaluation_backend.exception.ActivityTypeNotFoundException
import com.example.final_evaluation_backend.exception.InvalidRequestException
import com.example.final_evaluation_backend.mapper.ActivityTypeMapper.toResponseDTO
import com.example.final_evaluation_backend.model.ActivityType
import com.example.final_evaluation_backend.repository.ActivityTypeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ActivityTypeServiceImpl(
    private val activityTypeRepository: ActivityTypeRepository
): ActivityTypeService {
    @Transactional(rollbackFor = [Exception::class])
    override fun create(userId: Long, request: ActivityTypeRequest): ActivityTypeResponse {
        if (activityTypeRepository.existsByNameIgnoreCase(request.activityName)) {
            throw ActivityTypeAlreadyExists(request.activityName)
        }

        val entity = ActivityType(
            name = request.activityName,
            description = request.description
        )

        val saved = activityTypeRepository.save(entity)
        return saved.toResponseDTO()
    }
    @Transactional(rollbackFor = [Exception::class])
    override fun update(
        userId: Long,
        id: Long,
        request: ActivityTypeRequest
    ): ActivityTypeResponse {
        val existing = activityTypeRepository.findById(id)
            .orElseThrow { ActivityTypeNotFoundException(id) }

        if (existing.name.equals(request.activityName, ignoreCase = true).not() &&
            activityTypeRepository.existsByNameIgnoreCase(request.activityName)
        ) {
            throw InvalidRequestException("Activity type '${request.activityName}' already exists.")
        }

        existing.name = request.activityName
        existing.description = request.description

        val updated = activityTypeRepository.save(existing)
        return updated.toResponseDTO()
    }

    override fun getById(id: Long): ActivityTypeResponse {
        val entity = activityTypeRepository.findById(id)
            .orElseThrow { ActivityTypeNotFoundException(id) }

        return entity.toResponseDTO()
    }

    override fun getAll(): List<ActivityTypeResponse> {
        return activityTypeRepository.findAll()
            .map { it.toResponseDTO() }
    }
    @Transactional(rollbackFor = [Exception::class])
    override fun delete(userId: Long, id: Long) {
        if (!activityTypeRepository.existsById(id)) {
            throw ActivityTypeNotFoundException(id)
        }
        activityTypeRepository.deleteById(id)
    }
}