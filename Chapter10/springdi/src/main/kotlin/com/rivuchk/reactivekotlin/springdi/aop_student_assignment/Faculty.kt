package com.rivuchk.reactivekotlin.springdi.aop_student_assignment

import java.util.*

open class Faculty() {
    open public fun evaluateAssignment():Int {
        val marks = Random().nextInt(10)
        println("This assignment is evaluated and given $marks points")
        return marks
    }
}