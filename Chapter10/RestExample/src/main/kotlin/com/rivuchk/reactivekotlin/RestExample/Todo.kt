package com.rivuchk.reactivekotlin.RestExample

import javax.validation.constraints.NotBlank

data class Todo (
        var id:Int = 0,
        var todoDescription:String,
        var todoTargetDate:String,
        var status:String
)