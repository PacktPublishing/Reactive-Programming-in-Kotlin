package com.rivuchk.reactivekotlin.springdi.student_assignment

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext


class SpringdiApplication

fun main(args: Array<String>) {
    val context = AnnotationConfigApplicationContext (Configuration::class.java)
    val student = context.getBean(Student::class.java)
    student.completeAssignment("One")
    student.completeAssignment("Two")
    student.completeAssignment("Three")

    context.close()
}
