package com.example.final_evaluation_backend.exception

open class BaseException(
    override val message: String,
    val status: Int
) : RuntimeException(message)