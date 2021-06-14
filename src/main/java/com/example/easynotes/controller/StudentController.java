package com.example.easynotes.controller;


import com.example.easynotes.DTO.StudentDTO;
import com.example.easynotes.model.Student;
import com.example.easynotes.repository.myBatisMappers.StudentMapper;
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
        //return studentMapper.findAll();
    }
    @PostMapping("/create")
    void insert(@RequestBody Student student){
        //studentMapper.insert(student);
        studentService.insert(student);
    }

    @PostMapping("/update")
    void update(@RequestBody Student student){
        //studentMapper.update(student);
        studentService.update(student);
    }

    @PostMapping("/delete/{id}")
    void delete(@PathVariable Long id){
        //studentMapper.delete(id);
        studentService.delete(id);
    }
}
