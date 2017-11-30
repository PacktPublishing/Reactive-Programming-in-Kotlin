package com.rivuchk.reactivekotlin.todoapplication

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Todo (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id:Int = 0,

        @get: NotBlank
        var todoDescription:String,

        @get: NotBlank
        var todoTargetDate:String,

        @get: NotBlank
        var status:String
) {
        constructor():this(
                0,"","",""
        )
}