package com.example.easynotes.DTO;

import com.example.easynotes.model.Group;
import com.example.easynotes.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
public class StudentDTO extends Student {
    private Long groupId;

    public StudentDTO(@NotBlank String name, @NotBlank String email, Group group, Long groupId) {
        super(name, email, group);
        this.groupId = groupId;
    }

    public StudentDTO(Long id, String name, String email, Long groupId) {
        super(id, name, email);
        this.groupId = groupId;
    }

    public StudentDTO() {
    }
}
