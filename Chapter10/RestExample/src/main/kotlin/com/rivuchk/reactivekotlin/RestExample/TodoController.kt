package com.rivuchk.reactivekotlin.RestExample

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class TodoController {
    @RequestMapping("/get_todo")
    fun getTodo() = Todo(1,"TODO Project","31/11/2017","Running")
}