package com.rivuchk.reactivekotlin.todoapplication

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class TodoController(private val todoRepository: TodoRepository) {

    @RequestMapping("/get_todo", method = arrayOf(RequestMethod.POST))
    fun getTodos() = ResponseModel("0","", todoRepository.findAll())

    @RequestMapping("/add_todo", method = arrayOf(RequestMethod.POST))
    fun addTodo(@Valid @RequestBody todo:Todo) =
            ResponseEntity.ok().body(ResponseModel("0","",todoRepository.save(todo)))

    @RequestMapping("/edit_todo", method = arrayOf(RequestMethod.POST))
    fun editTodo(@Valid @RequestBody todo:Todo):ResponseModel {
        val optionalTodo = todoRepository.findById(todo.id)
        if(optionalTodo.isPresent) {
            return ResponseModel("0", "Edit Successful",todoRepository.save(todo))
        } else {
            return ResponseModel("1", "Invalid Todo ID" )
        }
    }

    @RequestMapping("/add_todos", method = arrayOf(RequestMethod.POST))
    fun addTodos(@Valid @RequestBody todos:List<Todo>)
            = ResponseEntity.ok().body(ResponseModel("0","",todoRepository.saveAll(todos)))

    @RequestMapping("/delete_todo/{id}", method = arrayOf(RequestMethod.DELETE))
    fun deleteTodo(@PathVariable("id") id:Int):ResponseModel {
        val optionalTodo = todoRepository.findById(id)
        if(optionalTodo.isPresent) {
            todoRepository.delete(optionalTodo.get())
            return ResponseModel("0", "Successfully Deleted")
        } else {
            return ResponseModel("1", "Invalid Todo" )
        }
    }

}