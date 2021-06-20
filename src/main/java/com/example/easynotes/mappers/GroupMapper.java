package com.example.easynotes.mappers;

import com.example.easynotes.DTO.StudentDTO;
import com.example.easynotes.model.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface GroupMapper {
    //Group findByCreatedDate(Date date);
    //Group findByName(String name);

    List<Group> findAllGroups();

    void createGroup(@Param("name") String name, @Param("createdDate") Timestamp createdDate);

    void updateGroup(@Param("id") Long id, @Param("name") String name);

    void deleteGroup(@Param("id") Long id);

    List<Group> findGroupByStudents(List<StudentDTO> students);

//    @Query(value = "SELECT * FROM groups g WHERE g.id in (:ids)", nativeQuery = true)
//    List<Group> findGroupByIds(@Param("ids") List<Long> ids);

}
