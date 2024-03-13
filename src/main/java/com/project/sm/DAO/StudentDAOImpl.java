package com.project.sm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.sm.api.Student;
import com.project.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Student> loadStudents() {

		// we will write logic to get me the student data
		// from database
		String sql = "Select* from Students";

		List<Student> theStudentList = jdbcTemplate.query(sql, new StudentRowMapper());

		return theStudentList;
	}

	public void saveStudent(Student student) {

		Object[] sqlParameter = { student.getName(), student.getMobile(), student.getCountry() };

		String sql = "insert into students(name,mobile,country) values(?,?,?)";

		jdbcTemplate.update(sql, sqlParameter);

		System.out.println("1 record inserted...");
	}

	public Student getStudent(int id) {
		
		String sql = "Select * from Students where id=?";
		
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		
		return student;
	}

	public void updateStudent(Student student) {
		
		String sql = "UPDATE STUDENTS SET name = ?, mobile = ?, country = ? WHERE id = ?";
		
		Object[] salParameter = {student.getName(),student.getMobile(),student.getCountry(),student.getId()};
		
		jdbcTemplate.update(sql, salParameter);
		
		System.out.println("student is Updated..");
	}

	public void deleteStudent(int id) {
		
		String sql = "Delete from Students where id = ?";
		jdbcTemplate.update(sql, id);
		
	}

}
