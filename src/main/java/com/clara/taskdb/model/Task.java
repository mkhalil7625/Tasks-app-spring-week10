package com.clara.taskdb.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Task {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   @Column(nullable = false)
    @Size(min=1)
    private String text;


    private boolean urgent;
   private boolean completed=false;
   public Task(){}

    public Task(String text, boolean urgent, boolean completed) {
        this.text = text;
        this.urgent = urgent;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", urgent=" + urgent +
                ", completed=" + completed +
                '}';
    }
}
