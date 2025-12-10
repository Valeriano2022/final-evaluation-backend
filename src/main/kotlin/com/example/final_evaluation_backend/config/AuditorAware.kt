package com.example.final_evaluation_backend.config

import com.example.final_evaluation_backend.security.CustomUserPrincipal
import org.springframework.data.domain.AuditorAware
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.Optional

@Component("auditorAware")
class AuditorAware : AuditorAware<Long> {
    override fun getCurrentAuditor(): Optional<Long> {
        val auth = SecurityContextHolder.getContext().authentication
        return when {
            auth == null || !auth.isAuthenticated || auth is AnonymousAuthenticationToken ->
                Optional.of(0)
            auth.principal is CustomUserPrincipal ->
                Optional.of((auth.principal as CustomUserPrincipal).userId)
            else ->
                Optional.ofNullable((auth.principal as CustomUserPrincipal).userId)
        }
    }
}