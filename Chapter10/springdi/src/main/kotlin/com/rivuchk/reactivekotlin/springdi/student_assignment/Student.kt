package com.rivuchk.reactivekotlin.springdi.student_assignment

class Student(val assignment: Assignment) {
    fun completeAssignment(assignmentDtl:String) {
        assignment.performAssignment(assignmentDtl)
    }
}