package com.example.easynotes.repository;

import com.example.easynotes.DTO.StudentDTO;
import com.example.easynotes.model.Group;
import com.example.easynotes.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByName(String name);
    Student findStudentByEmail(String email);
    List<Student> findStudentsByGroup(Group group);// ????? groupId or Group

//    @Query(value = "SELECT * FROM students s WHERE s.group_id in (SELECT g.id FROM groups g WHERE g.name like %:groupName%)", nativeQuery = true)
//    List<Student> findStudentsByGroupName(@Param("groupName") String groupName);

    //@Query(value = "SELECT new StudentDTO(s.id, s.name, s.email, s.group.id) FROM Student s WHERE s.group.id in (SELECT g.id FROM Group g WHERE g.name like %:groupName%)")
    @Query(value = "SELECT new com.example.easynotes.DTO.StudentDTO(s.id, s.name, s.email, s.group.id) FROM Student s WHERE s.group.id in (SELECT g.id FROM Group g WHERE g.name like %:groupName%)")
    List<StudentDTO> findStudentsByGroupName(@Param("groupName") String groupName);

    @Query(value = "SELECT new com.example.easynotes.DTO.StudentDTO(s.id, s.name, s.email, s.group.id) FROM Student s WHERE s.name like %:studentName%")
    List<StudentDTO> findStudentsByStudentName(@Param("studentName") String studentName);


}