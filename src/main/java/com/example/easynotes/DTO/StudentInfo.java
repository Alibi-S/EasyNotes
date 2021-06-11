package com.example.easynotes.DTO;

import com.example.easynotes.model.Group;
import com.example.easynotes.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentInfo {
    private List<StudentDTO> students;
    private List<Group> groups;
    private List<TeacherDTO> teachers;

}
