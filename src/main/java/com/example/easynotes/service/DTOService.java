package com.example.easynotes.service;


import com.example.easynotes.DTO.*;
import com.example.easynotes.mappers.GroupMapper;
import com.example.easynotes.mappers.StudentMapper;
import com.example.easynotes.mappers.TeacherMapper;
import com.example.easynotes.model.Group;
import com.example.easynotes.model.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DTOService {
//    @Autowired
//    private GroupRepository groupRepository;
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Autowired
//    private TeacherRepository teacherRepository;
//
//    public List<DataItem> findStudentInfoByName1(String studentName) {
//        List<DataItem> dataItems = new ArrayList<>();
//
//        List<StudentDTO> studentDTOS = studentRepository.findStudentsByStudentName(studentName);
//        for (StudentDTO s: studentDTOS) {
//            dataItems.add(s);
//            System.out.println(s.toString());
//        }
//
//        List<Group> groups = new ArrayList<>();
//        for (StudentDTO s: studentDTOS) {
//            Student student = studentRepository.getById(s.getId());
//            groups.add(student.getGroup());
//            dataItems.add(student.getGroup());
//            System.out.println(s.toString());
//        }
////
////        List<TeacherDTO> teacherDTOS = teacherRepository.findTeacherDTOSByGroupIds(groups);
////        for(TeacherDTO t: teacherDTOS) {
////            dataItems.add(t);
////            System.out.println(t.toString());
////        }
////        List
////        for(Group g: groups) {
////
////        }
////
//        System.out.println("------DATA ITEMS---------");
//        for (DataItem dataItem: dataItems) {
//            System.out.println(dataItem.toString());
//        }
//
//        return dataItems;
//    }
//
//
//    public StudentInfo findStudentInfoByName(String studentName) {
//        List<StudentDTO> studentDTOS = studentRepository.findStudentsByStudentName(studentName);
//        List<Group> groups = new ArrayList<>();
//        List<Long> groupIds = new ArrayList<>();
//        for (StudentDTO s: studentDTOS) {
//            Student student = studentRepository.getById(s.getId());
//            groups.add(student.getGroup());
//            groupIds.add(student.getGroup().getId());
//        }
//
//        List<TeacherDTO> teacherDTOS = new ArrayList<>(); //teacherRepository.findTeacherDTOSByGroupIds(groups);
//        List<Teacher> teachers = teacherRepository.findTeachersByGroupIds(groupIds);
//        for(Teacher t: teachers){
//            TeacherDTO teacherDTO = new TeacherDTO(t.getId(), t.getName(), t.getEmail());
//            teacherDTOS.add(teacherDTO);
//        }
//
//        StudentInfo studentInfo = new StudentInfo(studentDTOS, groups, teacherDTOS);
//
//        return studentInfo;
//    }
//
//    public GroupInfo findGroupInfoByStudentName(String studentName) {
//        List<StudentDTO> studentDTOS = studentRepository.findStudentsByStudentName(studentName);
//        List<Group> groups = new ArrayList<>();
//        List<Long> groupIds = new ArrayList<>();
//
//        for (StudentDTO s: studentDTOS) {
//            Student student = studentRepository.getById(s.getId());
//            groups.add(student.getGroup());
//            groupIds.add(student.getGroup().getId());
//        }
//
//        List<TeacherDTO> teacherDTOS = new ArrayList<>(); //teacherRepository.findTeacherDTOSByGroupIds(groups);
//        List<Teacher> teachers = teacherRepository.findTeachersByGroupIds(groupIds);
//
//        for(Teacher t: teachers){
//            TeacherDTO teacherDTO = new TeacherDTO(t.getId(), t.getName(), t.getEmail());
//            teacherDTOS.add(teacherDTO);
//        }
//
//        GroupInfo groupInfo = new GroupInfo(groups, teacherDTOS, studentDTOS);
//
//        return groupInfo;
//    }
//
//    public List<GroupDTO> findGroupInfoByTeacherName(String teacherName) {
//        Teacher teacher = teacherRepository.findTeacherByName(teacherName);
//
//        List<GroupDTO> groupDTOS = new ArrayList<>();
//        if (teacher != null) {
//            List<Group> groups = teacher.getGroups();
//            for (Group g : groups) {
//                List<Student> students = studentRepository.findStudentsByGroup(g);
//                List<StudentDTO> studentDTOS = new ArrayList<>();
//                for (Student s : students) {
//                    StudentDTO studentDTO = new StudentDTO(s.getId(), s.getName(), s.getEmail(), g.getId());
//                    studentDTOS.add(studentDTO);
//                }
//                GroupDTO groupDTO = new GroupDTO(g.getId(), g.getName(), g.getCreatedDate(), studentDTOS);
//                groupDTOS.add(groupDTO);
//            }
//        }
//        return groupDTOS;
//    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    public StudentInfo findStudentInfoByName(String studentName) {
        List<StudentDTO> students = studentMapper.findStudentsDtoByName(studentName);
        List<Group> groups = groupMapper.findGroupByStudents(students);
        List<TeacherDTO> teachers = teacherMapper.findTeachersDtoByGroups(groups);

        StudentInfo studentInfo = new StudentInfo(students, groups, teachers);

        return studentInfo;
    }

    public GroupInfo findGroupInfoByStudentName(String studentName) {
        List<StudentDTO> students = studentMapper.findStudentsDtoByName(studentName);
        List<Group> groups = groupMapper.findGroupByStudents(students);
        List<TeacherDTO> teachers = teacherMapper.findTeachersDtoByGroups(groups);
        students = studentMapper.findStudentsDtoByGroups(groups);

        GroupInfo groupInfo = new GroupInfo(groups, teachers, students);
        return groupInfo;
    }

    public List<GroupDTO> findGroupInfoByTeacherName(String teacherName) {
        List<Teacher> teachers = teacherMapper.findTeachersByName(teacherName);
        List<GroupDTO> groupDTOS = groupMapper.findGroupsDtoByTeachers(teachers);

        for(GroupDTO g: groupDTOS) {
            g.setStudents(studentMapper.findStudentsDtoByGroupId(g.getId()));
        }

        return groupDTOS;
    }
}
