package com.example.easynotes.mappers;


import com.example.easynotes.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {
    List<Teacher> findAllTeachers();
    void createTeacher(Teacher teacher);
}
