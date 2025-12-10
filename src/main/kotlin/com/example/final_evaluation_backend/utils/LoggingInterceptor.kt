package com.example.final_evaluation_backend.utils

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import kotlin.jvm.java

@Component
class   LoggingInterceptor : HandlerInterceptor {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any)
            : Boolean {
        log.info("️ ${request.method} ${request.requestURI}")
        return true
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any, ex: Exception?) {
        log.info("Response: ${response.status}")
    }
}