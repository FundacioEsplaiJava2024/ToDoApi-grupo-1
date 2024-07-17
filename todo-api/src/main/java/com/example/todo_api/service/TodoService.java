package com.example.todo_api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todo_api.entity.ToDo;
import com.example.todo_api.repository.TodoRepository;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public void addTask(ToDo todo) {
        this.todoRepository.save(todo);
    }

    public List<ToDo> getAllTask() {
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
