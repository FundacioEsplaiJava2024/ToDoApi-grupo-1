package com.example.todo_api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todo_api.entity.ToDo2;
import com.example.todo_api.repository.ToDoRepository2;


@Service
public class ToDoService2 {
    @Autowired
    private ToDoRepository2 todoRepository;

    public void addTask(ToDo2 todo) {
        this.todoRepository.save(todo);
    }

    public List<ToDo2> getAllTask() {
        return this.todoRepository.findAll();
    }

    public void editTask(Long toDoId) {
        //falta hacer!!!!!!!!!!!!!!!!!!!!!!1
    }

    public void deleteTask(Long toDoId){
        this.todoRepository.deleteById(toDoId);
    }
    public void closeTask(Long toDoId){
        //Falta por hacer
    }
    public void reOpenTask(Long toDoId){
        //Falta por hace
    }


}
