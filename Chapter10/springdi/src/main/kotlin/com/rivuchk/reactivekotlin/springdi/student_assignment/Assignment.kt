package com.rivuchk.reactivekotlin.springdi.student_assignment

class Assignment(val task:(String)->Unit) {
    fun performAssignment(assignmentDtl:String) {
        task(assignmentDtl)
    }
}