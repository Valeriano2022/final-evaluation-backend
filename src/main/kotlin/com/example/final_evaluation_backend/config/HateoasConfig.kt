package com.example.final_evaluation_backend.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.web.config.EnableSpringDataWebSupport
import org.springframework.hateoas.config.EnableHypermediaSupport

@Configuration
@EnableHypermediaSupport(type = [EnableHypermediaSupport.HypermediaType.HAL])
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
class HateoasConfig