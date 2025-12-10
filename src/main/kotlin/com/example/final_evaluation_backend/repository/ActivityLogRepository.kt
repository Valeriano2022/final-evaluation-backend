package com.example.final_evaluation_backend.repository

import com.example.final_evaluation_backend.model.ActivityLog
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ActivityLogRepository : JpaRepository<ActivityLog, Long>{
    fun findByStudentId(studentId: Long, pageable: Pageable): Page<ActivityLog>
}