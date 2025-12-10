package com.example.final_evaluation_backend.exception

class UnauthorizedOperationException(message: String) :
    BaseException(message, 401)