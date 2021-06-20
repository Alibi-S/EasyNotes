package com.example.easynotes.controller;

import com.example.easynotes.model.Group;
import com.example.easynotes.model.Student;
import com.example.easynotes.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("")
    public List<Group> findAllGroups() {
        return groupService.findAllGroups();
    }

    @PostMapping("/create")
    public void createGroup(@RequestBody Group group) {
        groupService.createGroup(group);
    }

    @PutMapping("/update")
    public void updateGroup(@RequestBody Group group) {
        groupService.updateGroup(group);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
    }
}
