package com.rivuchk.reactivekotlin.springdi.employee_task

class SoftwareDeveloper(val task: ProgrammingTask) : Employee {
    override fun executeTask() {
        task.execute()
    }
}