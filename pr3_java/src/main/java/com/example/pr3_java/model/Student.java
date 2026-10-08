package com.example.pr3_java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "course")
    private int course;

    @Column(name = "has_debt")
    private boolean hasDebt;

    public Student() {
    }

    public Student(String name, int course, boolean hasDebt) {
        this.name = name;
        this.course = course;
        this.hasDebt = hasDebt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public boolean isHasDebt() {
        return hasDebt;
    }

    public void setHasDebt(boolean hasDebt) {
        this.hasDebt = hasDebt;
    }
}
