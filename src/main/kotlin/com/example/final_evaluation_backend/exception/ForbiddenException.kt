package com.example.final_evaluation_backend.exception

class ForbiddenException(message: String) :
    BaseException(message, 403)