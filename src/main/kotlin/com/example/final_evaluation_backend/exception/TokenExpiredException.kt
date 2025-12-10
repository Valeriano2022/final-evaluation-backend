package com.example.final_evaluation_backend.exception

class TokenExpiredException():
    BaseException("Token is either expired!", 404)