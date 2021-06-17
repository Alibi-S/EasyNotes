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

    @PostMapping("/update")
    public void updateGroup(@RequestBody Group group) {
        groupService.updateGroup(group);
    }

    @PostMapping("/delete/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
    }


//    @GetMapping("/{id}")
//    public Optional<Group> findGroupById(@PathVariable Long id) {
//        return groupService.findGroupById(id);
//    }
//
//    @GetMapping("/name/{name}")
//    public Group findGroupByName(@PathVariable String name) {
//        return groupService.findGroupByName(name);
//    }
//
//    @GetMapping("/date/{date}")
//    public Group findGroupByDate(@PathVariable Date date) {
//        return groupService.findGroupByDate(date);
//    }
//
//    @PostMapping("/create")
//    public void createGroup(@RequestBody Group group) {
//        groupService.createGroup(group);
//    }
//
//    @PutMapping("/{id}")
//    public void updateGroup(@RequestBody Group group, @PathVariable Long id) {
//        groupService.updateGroup(group, id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteGroup(@PathVariable Long id) {
//        groupService.deleteGroup(id);
//    }

}
