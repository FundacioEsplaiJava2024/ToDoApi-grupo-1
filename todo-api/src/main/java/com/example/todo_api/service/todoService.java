package com.example.todo_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo_api.entity.ToDo;
import com.example.todo_api.repository.TodoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public void addTask(ToDo todo) {
        todoRepository.save(todo);
    }

    public List<ToDo> getAllTask() {
        return todoRepository.findAll();
    }

    public void editTask(Long toDoId, ToDo updatedToDo) {
        ToDo existingToDo = todoRepository.findById(toDoId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        existingToDo.settitle(updatedToDo.gettitle());
        existingToDo.setDescription(updatedToDo.getDescription());
        existingToDo.setDataCreated(updatedToDo.getDataCreated());
        existingToDo.setDeadLine(updatedToDo.getDeadLine());
        existingToDo.setPriority(updatedToDo.getPriority());
        existingToDo.setIsDoing(updatedToDo.getIsDoing());
        todoRepository.save(existingToDo);
    }

    public void deleteTask(Long toDoId) {
        todoRepository.deleteById(toDoId);
    }

    public Optional<ToDo> findTask(Long id) {
        return todoRepository.findById(id);
    }

    public ToDo applyPatchToToDo(JsonPatch patch, ToDo targetToDo) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetToDo, JsonNode.class));
        return objectMapper.treeToValue(patched, ToDo.class);
    }

    public void closeTask(Long toDoId) {
        ToDo existingToDo = todoRepository.findById(toDoId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        existingToDo.setIsDoing(false);  // Mark as closed
        todoRepository.save(existingToDo);
    }

    public void reOpenTask(Long toDoId) {
        ToDo existingToDo = todoRepository.findById(toDoId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        existingToDo.setIsDoing(true);  // Mark as reopened
        todoRepository.save(existingToDo);
    }
}
