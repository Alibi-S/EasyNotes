package com.example.easynotes.service;

import com.example.easynotes.mappers.StudentMapper;
import com.example.easynotes.model.Student;
//import com.example.easynotes.mappers.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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


    private StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> findAllStudents() {
        return studentMapper.findAllStudents();
    }

    public void createStudent(Student student) {
        studentMapper.createStudent(student);
    }

    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    public void deleteStudent(Long id) {
        studentMapper.deleteStudent(id);
    }

//    public void insert(Student student){
//        studentMapper.insert(student);
//    }
//
//    public void update(Student student){
//        studentMapper.update(student);
//    }
//
//    public void delete(Long id){
//        studentMapper.delete(id);
//    }

}
