package com.example.todo_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_api.entity.ToDo;
import com.example.todo_api.service.TodoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/tasks")
    public ResponseEntity<List<ToDo>>listTask() {
        List<ToDo> todos = new ArrayList<>();
        todos = todoService.getAllTask();

        return new ResponseEntity<List<ToDo>>(todos, HttpStatus.OK);
    }
    
    @PostMapping("/create-task")
    public ResponseEntity<ToDo> todo(@RequestBody ToDo todo){
        todoService.addTask(todo);

        return new ResponseEntity<ToDo>(HttpStatus.CREATED);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<ToDo> deletetask(@PathVariable("id") Long toDoid){
        todoService.deleteTask(toDoid);
        return ResponseEntity.ok().build();
    }
}
