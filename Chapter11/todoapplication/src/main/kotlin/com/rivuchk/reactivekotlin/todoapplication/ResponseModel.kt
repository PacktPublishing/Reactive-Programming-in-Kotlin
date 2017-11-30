package com.rivuchk.reactivekotlin.todoapplication

data class ResponseModel (
        val error_code:String,
        val error_message:String,
        val data:List<Todo> = listOf()
) {
    constructor(error_code: String,error_message: String,todo: Todo)
            :this(error_code,error_message, listOf(todo))
}