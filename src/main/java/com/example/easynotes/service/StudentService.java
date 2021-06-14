package com.example.easynotes.service;

import com.example.easynotes.DTO.StudentDTO;
import com.example.easynotes.model.Group;
import com.example.easynotes.model.Student;
import com.example.easynotes.repository.StudentRepository;
import com.example.easynotes.repository.myBatisMappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
//    @Autowired
//    private StudentRepository studentRepository;
//
//    public List<Student> findAllStudents() {
//        return studentRepository.findAll();
//    }
//
//    public Optional<Student> findStudentById(Long id) {
//        return studentRepository.findById(id);
//    }
//
//    public List<Student> findByName(String name) {
//        return studentRepository.findStudentByName(name);
//    }
//
//    public Student findByEmail(String email) {
//        return studentRepository.findStudentByEmail(email);
//    }
//
//    public List<Student> findByGroup(Group group) {
//        return studentRepository.findStudentsByGroup(group);
//    }
//
//    public List<StudentDTO> findByGroupName(String groupName) {
//        return studentRepository.findStudentsByGroupName(groupName);
//    }
//
//    public void createStudent(Student student) {
//        studentRepository.saveAndFlush(student);
//    }
//
//    public void updateStudent(Student student, Long id) {
//        Student studentFromDb = studentRepository.findById(id).orElse(null);
//        if(studentFromDb != null) {
//            studentFromDb.setName(student.getName());
//            studentFromDb.setEmail(student.getEmail());
//            studentFromDb.setGroup(student.getGroup());
//            studentRepository.saveAndFlush(studentFromDb);
//        }
//    }
//
//    public void deleteStudentById(Long id) {
//        studentRepository.deleteById(id);
//    }


    //////////////////////////////////////////////////////////////////////////////


    private StudentMapper studentMapper; // TODO Не забыть перенести все в Сервис

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> findAllStudents() {
        //return studentService.findAllStudents();
        return studentMapper.findAll();
    }

    public void insert(Student student){
        studentMapper.insert(student);
    }

    public void update(Student student){
        studentMapper.update(student);
    }

    public void delete(Long id){
        studentMapper.delete(id);
    }

}
