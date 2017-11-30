package com.rivuchk.reactivekotlin.springdi.aop_student_assignment

open class Student(public val assignment: Assignment) {
    open public fun completeAssignment(assignmentDtl:String) {
        assignment.performAssignment(assignmentDtl)
    }
}