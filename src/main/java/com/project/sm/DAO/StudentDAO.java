package com.project.sm.DAO;

import java.util.List;

import com.project.sm.api.Student;

public interface StudentDAO {

	List<Student> loadStudents();

	void saveStudent(Student student);

	Student getStudent(int id);

	void updateStudent(Student student);

	void deleteStudent(int id);
}

