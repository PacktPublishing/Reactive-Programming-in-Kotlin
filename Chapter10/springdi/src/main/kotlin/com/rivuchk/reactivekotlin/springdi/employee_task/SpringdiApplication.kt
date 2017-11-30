package com.rivuchk.reactivekotlin.springdi.employee_task

import org.springframework.context.support.ClassPathXmlApplicationContext


class SpringdiApplication

fun main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext(
            "META-INF/spring/employee.xml")

    val employee = context.getBean(Employee::class.java)
    employee.executeTask()
    context.close()
}
