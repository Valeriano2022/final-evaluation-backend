package com.example.final_evaluation_backend.exception

class ActivityTypeNotFoundException(id: Long) :

    BaseException("Activity Type $id not found.", 404)