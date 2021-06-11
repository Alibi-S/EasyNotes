package com.example.easynotes.controller;


import com.example.easynotes.DTO.StudentDTO;
import com.example.easynotes.model.Student;
import com.example.easynotes.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> findStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/name/{name}")
    public List<Student> findByName(@PathVariable String name) {
        return studentService.findByName(name);
    }

    @GetMapping("/email/{email}")
    public Student findByEmail(@PathVariable String email) {
        return studentService.findByEmail(email);
    }

    @GetMapping("/group-name/{groupName}")
    public List<StudentDTO> findByGroupName(@PathVariable String groupName) {
        return studentService.findByGroupName(groupName);
    }

    @PostMapping("/create")
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable Long id) {
        studentService.updateStudent(student, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
}
