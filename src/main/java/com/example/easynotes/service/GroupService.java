package com.example.easynotes.service;

import com.example.easynotes.model.Group;
import com.example.easynotes.model.Student;
import com.example.easynotes.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }

    //id name date
    public Optional<Group> findGroupById(Long id) {
        return groupRepository.findById(id);
    }

    public Group findGroupByName(String name){
        return groupRepository.findByName(name);
    }

    public Group findGroupByDate(Date date) {
        return groupRepository.findByCreatedDate(date);
    }

    public void createGroup(Group group) {
        groupRepository.saveAndFlush(group);
    }

    public void updateGroup(Group group, Long id) {
        Group groupFromDb = groupRepository.findById(id).orElse(null);
        if (groupFromDb != null) {
            groupFromDb.setName(group.getName());
            groupFromDb.setCreatedDate(group.getCreatedDate());
            groupRepository.saveAndFlush(groupFromDb);
        }
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }

//    public List<Group> findGroupByStudents(List<Student> students) {
//        return groupRepository.findByStudents(students);
//    }

}
