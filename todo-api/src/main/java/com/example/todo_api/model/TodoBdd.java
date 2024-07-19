package com.example.todo_api.model;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class TodoBdd {

    @Id
    @Column(name = "id", length = 36)
    @GeneratedValue(generator = "UUID")
    private String id;

    @Column(name = "title", length = 36)
    private String title;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "dataCreated")
    private Date dataCreatDate;

    @Column(name = "deadLine")
    private Date deadLDate;

    @Column(name = "priority", length = 10)
    private String priority;

    @Column(name = "isDoing")
    private boolean isDoing;

}
