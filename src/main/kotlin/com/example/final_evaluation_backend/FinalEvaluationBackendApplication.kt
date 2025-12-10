package com.example.final_evaluation_backend

import com.example.final_evaluation_backend.config.JpaAuditingConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@Import(JpaAuditingConfig::class)
class FinalEvaluationBackendApplication

fun main(args: Array<String>) {
	runApplication<FinalEvaluationBackendApplication>(*args)
}
