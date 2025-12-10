package com.example.final_evaluation_backend.repository

import com.example.final_evaluation_backend.model.ActivityType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ActivityTypeRepository : JpaRepository<ActivityType, Long>{
    fun existsByNameIgnoreCase(name: String): Boolean
}