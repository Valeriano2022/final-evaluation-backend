package com.example.final_evaluation_backend.exception

class InvalidRequestException(message: String) :
    BaseException(message, 400)