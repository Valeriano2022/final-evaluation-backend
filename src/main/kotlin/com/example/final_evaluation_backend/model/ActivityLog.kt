package com.example.final_evaluation_backend.model

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@Entity
@Table(name = "activity_logs")
class ActivityLog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    var student: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_type_id", nullable = false)
    var activityType: ActivityType,

    @Column(nullable = true)
    var title: String? = null,

    @Column(nullable = false, columnDefinition = "TEXT")
    var description: String,

    @Column(name = "duration_minutes")
    var durationMinutes: Int? = null,

    @Column(nullable = false)
    var date: LocalDate,

    @Column(name = "start_time")
    var startTime: LocalTime? = null,

    @Column(name = "end_time")
    var endTime: LocalTime? = null,
): BaseEntity()
