package com.example.todo_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todo_api.entity.ToDo;
import com.example.todo_api.service.TodoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public String addToDo() {
        ToDo todo = new ToDo();
        todoService.getAllTask();
        
        return "todo";
    }
    

    @PostMapping
    public String todo(ToDo toDo){
        todoService.getAllTask();
        this.todoService.addTask(toDo);


        return "redirect: /todo";
    }
    
    
}
