package com.example.easynotes.model;

import com.example.easynotes.DTO.DataItem;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "students")
public class Student implements DataItem {
    //id, name, email, group_id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group;

    public Student(@NotBlank String name, @NotBlank String email, Group group) {
        this.name = name;
        this.email = email;
        this.group = group;
    }

    public Student() {
    }

    public Student(Long id, @NotBlank String name, @NotBlank String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

