package com.example.todo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.todo_api.entity.ToDo2;

@Repository
public interface ToDoRepository2 extends JpaRepository<ToDo2, Long>{
}
