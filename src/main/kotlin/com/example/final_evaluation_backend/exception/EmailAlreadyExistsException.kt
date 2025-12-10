package com.example.final_evaluation_backend.exception

class EmailAlreadyExistsException(email: String) :
    BaseException("Email already exists: $email", 409)