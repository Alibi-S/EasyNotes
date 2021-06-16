package com.example.easynotes.mappers;

import com.example.easynotes.model.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public class GroupMapper {
    //Group findByCreatedDate(Date date);
    //Group findByName(String name);

    public List<Group> findAllGroups() {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        List<Group> groups = session.selectList("findAllGroups");
        session.commit();
        session.close();

        return groups;
    }



//    @Query(value = "SELECT * FROM groups g WHERE g.id in (:ids)", nativeQuery = true)
//    List<Group> findGroupByIds(@Param("ids") List<Long> ids);

}
