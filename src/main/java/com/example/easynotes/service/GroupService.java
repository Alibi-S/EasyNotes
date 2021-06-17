package com.example.easynotes.service;

import com.example.easynotes.model.Group;
import com.example.easynotes.mappers.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class GroupService {
//    @Autowired
//    private GroupRepository groupRepository;
//
//    public List<Group> findAllGroups() {
//        return groupRepository.findAll();
//    }
//
//    //id name date
//    public Optional<Group> findGroupById(Long id) {
//        return groupRepository.findById(id);
//    }
//
//    public Group findGroupByName(String name){
//        return groupRepository.findByName(name);
//    }
//
//    public Group findGroupByDate(Date date) {
//        return groupRepository.findByCreatedDate(date);
//    }
//
//    public void createGroup(Group group) {
//        groupRepository.saveAndFlush(group);
//    }
//
//    public void updateGroup(Group group, Long id) {
//        Group groupFromDb = groupRepository.findById(id).orElse(null);
//        if (groupFromDb != null) {
//            groupFromDb.setName(group.getName());
//            groupFromDb.setCreatedDate(group.getCreatedDate());
//            groupRepository.saveAndFlush(groupFromDb);
//        }
//    }
//
//    public void deleteGroup(Long id) {
//        groupRepository.deleteById(id);
//    }

//    public List<Group> findGroupByStudents(List<Student> students) {
//        return groupRepository.findByStudents(students);
//    }

    /////////////////////////////////////////////////////////////////////////////////////////

    @Autowired
    private GroupMapper groupMapper;

    public GroupService(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    public List<Group> findAllGroups() {
        return groupMapper.findAllGroups();
    }

    public void createGroup(Group group) {
        groupMapper.createGroup( group.getName(), new Timestamp( new Date().getTime()));
    }

    public void updateGroup(Group group) {
        groupMapper.updateGroup(group.getId(), group.getName());
    }

    public void deleteGroup(Long id) {
        groupMapper.deleteGroup(id);
    }

}
