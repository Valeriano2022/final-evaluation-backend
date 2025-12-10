package com.example.final_evaluation_backend.exception

class UserAlreadyLoggedIn(id: Long):
    BaseException("User already logged in: $id", 400)