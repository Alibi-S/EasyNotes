package com.example.easynotes.controller;


import com.example.easynotes.model.Student;
import com.example.easynotes.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @PostMapping("/create")
    void insert(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @PutMapping("/update")
    void update(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
