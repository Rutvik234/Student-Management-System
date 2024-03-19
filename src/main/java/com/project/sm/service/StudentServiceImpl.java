package com.project.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sm.DAO.StudentDAO;
import com.project.sm.api.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public List<Student> loadStudents() {

		List<Student> studentList = studentDAO.loadStudents();

		return studentList;
	}

	public void saveStudent(Student student) {

		if (student.getName().equals("Radha")) {

			System.out.println("mail sent to : " + student.getName());

		}

		studentDAO.saveStudent(student);

	}

	public Student getStudent(int id) {

		return studentDAO.getStudent(id);
	}

	public void updateStudent(Student student) {

		studentDAO.updateStudent(student);

	}

	public void deleteStudent(int id) {

		studentDAO.deleteStudent(id);

	}

}
