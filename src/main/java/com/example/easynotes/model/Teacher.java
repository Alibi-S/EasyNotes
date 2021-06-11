package com.example.easynotes.model;

import com.example.easynotes.DTO.DataItem;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher implements DataItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade	= CascadeType.PERSIST)
    @JoinTable(name	= "lessons",
            joinColumns	= {
                    @JoinColumn(name = "teacher_id",
                            referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "group_id",
                            referencedColumnName = "id")})
    private List<Group> groups;

    public Teacher(Long id, @NotBlank String name, @NotBlank String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
