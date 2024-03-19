package com.project.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.sm.api.Student;
import com.project.sm.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String homeStudent() {

		return "home-student";
	}

	@GetMapping("/showStudent")
	public String showAllStrudent(Model model) {

		// call service method to get the data

		List<Student> studentList = studentService.loadStudents();

		model.addAttribute("students", studentList);

		return "student-list";
	}

	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model) {

		Student student = new Student();

		model.addAttribute("student", student);

		return "add-student";
	}

	@PostMapping("/save-student")
	public String saveStudent(Student student) {

		System.out.println(student);

		// student service call to save data
		// if id is not 0 the update records
		// if id is 0 the insert the records

		if (student.getId() == 0) {
			studentService.saveStudent(student);
		}

		else {
			studentService.updateStudent(student);
		}

		return "redirect:/showStudent";
	}

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id, Model model) {

		// we should give the user object who clicked on the update button
		System.out.println("looking for data is " + id);

		Student theStudent = studentService.getStudent(id);
		System.out.println(theStudent);

		model.addAttribute("student", theStudent);

		return "update-student";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id) {

		// captur the id of student whom you are trying to delete
		// once captured the id, do a service call to delete student

		studentService.deleteStudent(id);

		return "redirect:/showStudent";
	}

}
