package com.example.easynotes.repository;

import com.example.easynotes.model.Group;
import com.example.easynotes.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByCreatedDate(Date date);
    Group findByName(String name);

//    @Query(value = "SELECT * FROM teachers t WHERE    WHERE g.name like %:groupName%)", nativeQuery = true)
    @Query(value = "SELECT * FROM groups g WHERE g.id in (:ids)", nativeQuery = true)
    List<Group> findGroupByIds(@Param("ids") List<Long> ids);
    //List<Group> findByStudents(List<Student> students);
}
