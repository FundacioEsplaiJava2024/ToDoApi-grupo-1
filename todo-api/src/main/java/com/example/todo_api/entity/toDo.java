package com.example.todo_api.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")

public class toDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String title;
    private String description;
    private Date dataCreated;
    private Date deadLine;
    private String priority;
    private Boolean isDoing;

    public toDo() {

    }

    public toDo(String title, String description, Date dataCreated, Date deadLine, String priority, Boolean isDoing) {
        this.title = title;
        this.description = description;
        this.dataCreated = dataCreated;
        this.deadLine = deadLine;
        this.priority = priority;
        this.isDoing = isDoing;
    }

    public Long getId() {
        return id;
    }
    public String gettitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public Date getDataCreated() {
        return dataCreated;
    }
    public Date getDeadLine() {
        return deadLine;
    }
    public String getPriority() {
        return priority;
    }
    public Boolean getIsDoing() {
        return isDoing;
    }


    public void setId(long id) {
        this.id = id;
    }
    public void settitle(String title) {
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setDataCreated(Date dataCreated){
        this.dataCreated = dataCreated;
    }
    public void setDeadLine(Date deadLine){
        this.deadLine = deadLine;
    }
    public void setPriority(String priority){
        this.priority = priority;
    }
    public void setIsDoing(Boolean isDoing){
        this.isDoing = isDoing;
    }

}
