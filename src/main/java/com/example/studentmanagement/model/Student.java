package com.example.studentmanagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 6, message = "ten phai lon hon 6 ky tu")
    private String name;
    private int age;
    private double point;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "classes_id")
    private Classes classes;

    public Student() {
    }

    public Student(String name, int age, double point, String gender, Classes classes) {
        this.name = name;
        this.age = age;
        this.point = point;
        this.gender = gender;
        this.classes = classes;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public Classes getClasses() {
        return classes;
    }


    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
