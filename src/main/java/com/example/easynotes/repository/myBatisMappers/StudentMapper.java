package com.example.easynotes.repository.myBatisMappers;

import com.example.easynotes.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Select("Select * from students;")
    List<Student> findAll();

    @Insert("Insert into students(email, name, group_id) values(#{name}, #{email}, #{group.id})")
    void insert(Student student);
}
