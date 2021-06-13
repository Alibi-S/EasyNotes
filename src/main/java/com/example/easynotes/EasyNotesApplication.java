package com.example.easynotes;

import com.example.easynotes.model.Student;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@MappedTypes(Student.class)
@MapperScan("com.example.easynotes.repository.myBatisMappers")
public class EasyNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyNotesApplication.class, args);
	}

}

//Нужно создать получается, две таблицы, student и group
//у student есть id, name, email, group_id
//у group есть id, name, created_date
//
//тут обязательно должен быть reference student.group_id  с group.id
//
//Дальше нужно для этих двух таблиц создать классы, репо, сервис, рест для того чтобы через rest мы могли данные обновлять, создавать, вытаскивать
//
//
//
//
//
//	teacher {
//		id
//		name
//		email
//	}
//
//	teacher_group_map {//lesson
//		id
//		name
//		teacher_id
//		group_id
//	}
//
//- CRUD - teacher, teacher_group_map
//		- Search student by name:
//		{
//			student: {
//				id
//				name
//				...
//			},
//			teacher: {
//				id
//				name
//				...
//			},
//			group: {
//				id
//				name
//				...
//			}
//		}
//		- Search group by student name:
//		{
//			group: {
//				id
//				name
//				...
//			},
//			teachers: {
//				id
//				name
//			},
//			student: {
//				id
//				name
//			}
//		}
//		- List by teacher name:
//		{
//			groups: [{
//				id
//				name
//				...
//				students: [{
//					id
//					name
//					...
//				}]
//			}],
//		}
//
//


























