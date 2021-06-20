package com.example.easynotes.service;

import com.example.easynotes.mappers.TeacherMapper;
import com.example.easynotes.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public List<Teacher> findAllTeachers() {
        return teacherMapper.findAllTeachers();
    }

    public void createTeacher(Teacher teacher) {
        teacherMapper.createTeacher(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherMapper.deleteTeacher(id);
    }
//    @Autowired
//    private TeacherRepository teacherRepository;
//
//    public List<Teacher> findAllTeachers() {
//        return teacherRepository.findAll();
//    }
//
//    public Optional<Teacher> findTeacherById(Long id) {
//        return teacherRepository.findById(id);
//    }
//
//    public Teacher findByName(String name) {
//        return teacherRepository.findTeacherByName(name);
//    }
//
//    public Teacher findByEmail(String email) {
//        return teacherRepository.findTeacherByEmail(email);
//    }
//
//    public void createTeacher(Teacher teacher) {
//        teacherRepository.saveAndFlush(teacher);
//    }
//
//    public void updateTeacher(Teacher teacher, Long id) {
//        Teacher teacherFromDb = teacherRepository.findById(id).orElse(null);
//        if(teacherFromDb != null) {
//            teacherFromDb.setName(teacher.getName());
//            teacherFromDb.setEmail(teacher.getEmail());
//            teacherFromDb.setGroups(teacher.getGroups());
//            teacherRepository.saveAndFlush(teacherFromDb);
//        }
//    }
//
//    public void deleteTeacherById(Long id) {
//        teacherRepository.deleteById(id);
//    }
//
//    public List<Teacher> findTeacherByGroups(List<Group> groups) {
//        return teacherRepository.findTeachersByGroups(groups);
//    }
}
