package com.example.easynotes.DTO;

import com.example.easynotes.model.Group;
import com.example.easynotes.model.Student;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
public class GroupDTO extends Group {
    private List<StudentDTO> students;

    public GroupDTO(Long id, @NotBlank String name, Date createdDate, List<StudentDTO> students) {
        super(id, name, createdDate);
        this.students = students;
    }

    public GroupDTO(Long id, @NotBlank String name, Date createdDate) {
        super(id, name, createdDate);
    }

    public GroupDTO(List<StudentDTO> students) {
        this.students = students;
    }
}
