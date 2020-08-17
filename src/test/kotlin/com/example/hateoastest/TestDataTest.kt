package com.example.hateoastest

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.convertValue
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.InstanceOfAssertFactories
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import
import org.springframework.hateoas.Link
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@Import(value = [JacksonConfiguration::class, HypermediaConfiguration::class])
class TestDataTest {
    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun test() {
        val dataClass = TestData(
                data = "some data",
                selfLink = Link.of("http://localhost/self", "self"),
                otherLink = Link.of("http://localhost/other", "other"))
        val mappedClass: Map<String, Any?> = objectMapper.convertValue(dataClass)

        assertThat(mappedClass).hasEntrySatisfying("_links") {
            assertThat(it)
                    .asInstanceOf(InstanceOfAssertFactories.MAP)
                    .containsEntry("self", "http://localhost/self")
                    .containsEntry("other", "http://localhost/other")
        }
    }
}