package com.example.hateoastest

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.hateoas.config.EnableHypermediaSupport
import org.springframework.hateoas.support.WebStack

@Configuration
@DependsOn( value = ["objectMapper"])
@EnableHypermediaSupport(type = [EnableHypermediaSupport.HypermediaType.HAL], stacks = [WebStack.WEBMVC])
class HypermediaConfiguration {

}