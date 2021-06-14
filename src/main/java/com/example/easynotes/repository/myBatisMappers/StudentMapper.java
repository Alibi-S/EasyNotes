package com.example.easynotes.repository.myBatisMappers;

import com.example.easynotes.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Select("Select * from students;")
    List<Student> findAll();

    @Insert("Insert into students(email, name, group_id) values(#{email}, #{name}, #{group.id})")
    void insert(Student student);

    @Update("Update students set email=#{email}, name=#{name}, group_id=#{group.id} where id=#{id}")
    public void update(Student student);

    @Delete("Delete from students where id=#{id}")
    void delete(Long id);
}
