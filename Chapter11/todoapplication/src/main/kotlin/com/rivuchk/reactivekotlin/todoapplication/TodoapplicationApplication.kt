package com.rivuchk.reactivekotlin.todoapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodoapplicationApplication

fun main(args: Array<String>) {
    runApplication<TodoapplicationApplication>(*args)
}
