package com.rivuchk.reactivekotlin.springdi.aop_student_assignment

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext


class SpringdiApplication

fun main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext(
            "META-INF/spring/student_faculty.xml"
    )
    val student = context.getBean(Student::class.java)
    student.completeAssignment("One")
    student.completeAssignment("Two")
    student.completeAssignment("Three")

    context.close()
}
