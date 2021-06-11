package com.example.easynotes.DTO;

import com.example.easynotes.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class TeacherDTO extends Teacher {
    public TeacherDTO(Long id, @NotBlank String name, @NotBlank String email) {
        super(id, name, email);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
