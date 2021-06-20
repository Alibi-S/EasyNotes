package com.example.easynotes.controller;
import com.example.easynotes.DTO.*;
import com.example.easynotes.service.DTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dto")
public class DTOController {
    @Autowired
    private DTOService dtoService;


    // Я пытался сделать здесь первый таск, идея была такая, чтобы дать всем моделькам пустой интерфейс и
    // вернуть просто список объектов, различных типов, но имплементящих один интерфейс. По итогу получилось
    // выводить Студентов и Группы, но с учителями возникли непонятные проблемы. Потом может быть разберусь.
    // Но как итог, получилось выводить в json, список состоящий из Студентов и Групп, хотя они разного типа и с полями

//    @GetMapping("/student-name/dataItem/{studentName}")
//    public List<DataItem> findStudentInfoByStudentName1(@PathVariable String studentName) {
//        return dtoService.findStudentInfoByName1(studentName);
//    }

    // 1 TASK
//    - Search student by name:
//    {
//        student: {
//            id
//            name
//		      ...
//        },
//        teacher: {
//            id
//            name
//			  ...
//        },
//        group: {
//            id
//            name
//			  ...
//        }
//    }
//    Я тут создал класс StudentInfo для того чтобы вывести в таком же порядке как выше, в задании. В след таске тоже.

    @GetMapping("/student-name/{studentName}")
    public StudentInfo findStudentInfoByStudentName(@PathVariable String studentName) {
        return dtoService.findStudentInfoByName(studentName);
    }

    // 2 TASK
//    - Search group by student name:
//    {
//        group: {
//            id
//            name
//				...
//        },
//        teachers: {
//            id
//            name
//        },
//        student: {
//            id
//            name
//        }
//    }
//    @GetMapping("/group-info/student-name/{studentName}")
//    public GroupInfo findGroupInfoByStudentName(@PathVariable String studentName) {
//        return dtoService.findGroupInfoByStudentName(studentName);
//    }

    // 3 TASK
//    - List by teacher name:
//    {
//        groups: [{
//              id
//              name
//				...
//              students: [{
//                  id
//                  name
//					...
//              }]
//        }],
//    }
//    @GetMapping("/group-info/teacher-name/{teacherName}")
//    public List<GroupDTO> findGroupInfoByTeacherName(@PathVariable String teacherName) {
//        return dtoService.findGroupInfoByTeacherName(teacherName);
//    }
}
