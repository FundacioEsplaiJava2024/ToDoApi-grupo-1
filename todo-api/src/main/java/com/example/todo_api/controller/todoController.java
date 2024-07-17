package com.example.todo_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.todo_api.entity.ToDo;
import com.example.todo_api.service.TodoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;



@RestController
@RequestMapping("/todo")
public class TodoController{
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

    @PatchMapping(path = "/edit/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<ToDo> updateTask(@PathVariable Long id, @RequestBody JsonPatch patch) {
        try {
            ToDo toDo = todoService.findTask(id).orElseThrow(() -> new RuntimeException("Task not found"));
            ToDo patchedToDo = todoService.applyPatchToToDo(patch, toDo);
            todoService.editTask(id, patchedToDo);
            return ResponseEntity.ok(patchedToDo);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/close-tasks/{id}")
    public ResponseEntity<Void> closeTask(@PathVariable Long id) {
        todoService.closeTask(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/reopen-tasks/{id}")
    public ResponseEntity<Void> reOpenTask(@PathVariable Long id) {
        todoService.reOpenTask(id);
        return ResponseEntity.noContent().build();
    }
}
