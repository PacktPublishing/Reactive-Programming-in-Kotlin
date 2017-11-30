package com.rivuchk.reactivekotlin.springdi.aop_student_assignment

open class Assignment() {
    open public fun performAssignment(assignmentDtl:String) {
        println("Performing Assignment $assignmentDtl")
    }
}