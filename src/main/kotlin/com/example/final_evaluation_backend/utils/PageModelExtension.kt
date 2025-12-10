package com.example.final_evaluation_backend.utils

import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.PagedModel

@Suppress("UNCHECKED_CAST")
fun <T : Any> PagedModel<*>.cast(): PagedModel<EntityModel<T>> =
    this as PagedModel<EntityModel<T>>