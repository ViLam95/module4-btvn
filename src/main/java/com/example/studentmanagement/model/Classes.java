package com.example.studentmanagement.model;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes")
public class Classes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "number_student")
    private Integer quantity ;

    public Classes() {
    }

    public Classes(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
