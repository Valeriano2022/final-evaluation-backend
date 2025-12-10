package com.example.final_evaluation_backend.exception

class UserNotFoundException(email: String? = null, id: Long? = null) :

    BaseException("User not found: ${email ?: id}", 404)