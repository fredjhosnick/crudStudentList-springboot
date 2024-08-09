package com.app.web.service;

import java.util.List;

import com.app.web.entity.Student;

public interface StudentService {
	public List<Student> listAllStudent();
	
	public Student saveStudent(Student student);
	
	public Student getStudentById(Long id);
	
	public Student updateStudent(Student student);
	
	public void deleteStudent(Long id);

}
