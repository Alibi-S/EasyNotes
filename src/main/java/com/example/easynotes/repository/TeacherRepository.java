package com.example.easynotes.repository;

import com.example.easynotes.DTO.StudentDTO;
import com.example.easynotes.DTO.TeacherDTO;
import com.example.easynotes.model.Group;
import com.example.easynotes.model.Student;
import com.example.easynotes.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findTeacherByName(String name);
    Teacher findTeacherByEmail(String email);

    @Query(value = "SELECT * FROM teachers t WHERE t.id in (SELECT l.teacher_id FROM lessons l WHERE l.group_id in (:groupIds))", nativeQuery = true)
    List<Teacher> findTeachersByGroupIds(@Param("groupIds") List<Long> groupIds);

    @Query(value = "SELECT new com.example.easynotes.DTO.TeacherDTO(t.id, t.name, t.email) FROM Teacher t WHERE t.groups in (:groups)")
    List<TeacherDTO> findTeacherDTOSByGroupIds(@Param("groups") List<Group> groups);

    //@Query(value = "SELECT * FROM teachers t WHERE    WHERE g.name like %:groupName%)", nativeQuery = true)
    //List<Teacher> findTeacherByStudentList(List<Student> students);

    //Teacher findTeacherByLessonName(Strein lessonName);// FIND BY LESSON
    //List<Teacher> findTeachersByGroups(List<Group> groups);

//    @Query(value = "SELECT new com.example.easynotes.DTO.TeacherDTO(t.id, t.name, t.email) FROM Teacher t WHERE")
//    List<StudentDTO> findStudentsByGroupName(@Param("groupName") String groupName);
}
