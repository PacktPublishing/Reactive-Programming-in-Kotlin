package com.rivuchk.reactivekotlin.springdi.student_assignment

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration {

    @Bean
    fun student() = Student(assignment())

    @Bean
    fun assignment()
            = Assignment { assignmentDtl -> println("Performing Assignment $assignmentDtl") }
}