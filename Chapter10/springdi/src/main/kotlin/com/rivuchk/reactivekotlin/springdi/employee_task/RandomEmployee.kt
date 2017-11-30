package com.rivuchk.reactivekotlin.springdi.employee_task

class RandomEmployee: Employee {
    val task = RandomTask()
    override fun executeTask() {
        task.execute()
    }
}