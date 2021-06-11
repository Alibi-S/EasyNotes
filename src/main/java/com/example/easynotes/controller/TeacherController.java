package com.example.easynotes.controller;

import com.example.easynotes.model.Teacher;
import com.example.easynotes.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("")
    public List<Teacher> findAllTeachers() {
        return teacherService.findAllTeachers();
    }

    @GetMapping("/{id}")
    public Optional<Teacher> findTeacherById(@PathVariable Long id) {
        return teacherService.findTeacherById(id);
    }

    @GetMapping("/name/{name}")
    public Teacher findByName(@PathVariable String name) {
        return teacherService.findByName(name);
    }

    @GetMapping("/email/{email}")
    public Teacher findByEmail(@PathVariable String email) {
        return teacherService.findByEmail(email);
    }


    @PostMapping("/create")
    public void createTeacher(@RequestBody Teacher teacher) {
        teacherService.createTeacher(teacher);
    }

    @PutMapping("/{id}")
    public void updateTeacher(@RequestBody Teacher teacher, @PathVariable Long id) {
        teacherService.updateTeacher(teacher, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }
}
