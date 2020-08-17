package com.example.hateoastest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackageClasses = [HateoastestApplication::class])
class HateoastestApplication

fun main(args: Array<String>) {
    runApplication<HateoastestApplication>(*args)
}
