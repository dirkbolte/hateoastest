package com.example.hateoastest

import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule

@Configuration
class JacksonConfiguration {
    private val mapper = jacksonObjectMapper()
            .registerModule(ParameterNamesModule())
            .registerModule(Jdk8Module())
//            .registerModule(Jackson2HalModule()) results in: HalLinkListSerializer has no default (no arg) constructor

    @Bean
    fun objectMapper() = mapper
}
