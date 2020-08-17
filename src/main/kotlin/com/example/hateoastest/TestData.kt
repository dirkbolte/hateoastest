package com.example.hateoastest

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.hateoas.Link
import org.springframework.hateoas.RepresentationModel

data class TestData(
        @JsonProperty("data")
        val data: String
) : RepresentationModel<TestData>() {
    constructor(data: String, selfLink: Link, otherLink: Link) : this(data) {
        add(selfLink)
        add(otherLink)
    }
}