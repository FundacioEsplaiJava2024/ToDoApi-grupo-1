package com.example.todo_api.model;

public class toDo {
    private Long id;
    private String name;

    public toDo() {

    }

    public toDo(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;

    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNAme( String name){
        
    }

}
