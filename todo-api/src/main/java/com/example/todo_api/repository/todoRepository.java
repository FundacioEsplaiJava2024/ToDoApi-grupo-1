package com.example.todo_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.todo_api.entity.ToDo;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, Long>{
}
