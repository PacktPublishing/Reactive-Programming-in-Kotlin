package com.rivuchk.todoapplication.datamodels

import java.io.Serializable

/**
 * Created by Rivu on 01-11-2017.
 */
data class ToDoModel (
        val id:Int,
        var todoDescription:String,
        var todoTargetDate:String,
        var status:String
):Serializable