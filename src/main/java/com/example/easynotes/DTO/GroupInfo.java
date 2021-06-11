package com.example.easynotes.DTO;

import com.example.easynotes.model.Group;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GroupInfo {
    private List<Group> groups;
    private List<TeacherDTO> teachers;
    private List<StudentDTO> students;

}
