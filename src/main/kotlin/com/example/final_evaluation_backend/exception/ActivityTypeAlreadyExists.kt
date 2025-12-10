package com.example.final_evaluation_backend.exception

class ActivityTypeAlreadyExists(activityName: String):
    BaseException("Activity Type $activityName already exists!", 400)