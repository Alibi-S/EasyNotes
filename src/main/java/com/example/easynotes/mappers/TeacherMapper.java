package com.example.easynotes.mappers;


import com.example.easynotes.DTO.TeacherDTO;
import com.example.easynotes.model.Group;
import com.example.easynotes.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {
    List<Teacher> findAllTeachers(); // TODO Вывести всех учителей даже у которых нет групп.
    void createTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Long id);

    List<TeacherDTO> findTeachersDtoByGroups(List<Group> groups);

    List<Teacher> findTeachersByName(String teacherName);
}

