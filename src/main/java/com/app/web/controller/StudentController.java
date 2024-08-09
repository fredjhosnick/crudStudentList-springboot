package com.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entity.Student;
import com.app.web.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping({ "/students", "/" })
	public String listStudent(Model model) {
		model.addAttribute("students", service.listAllStudent());
		return "students";// it returns us file students
	}

	@GetMapping("/students/new")
	public String showStudentRegisterFormular(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";

	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";

	}

	@GetMapping("/students/edit/{id}")
	public String showFormularEdit(@PathVariable Long id, Model model) {

		model.addAttribute("student", service.getStudentById(id));

		return "edit_student";

	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

		Student studentExist = service.getStudentById(id);
		studentExist.setId(id);
		studentExist.setName(student.getName());
		studentExist.setSurname(student.getSurname());
		student.setEmail(student.getEmail());

		service.updateStudent(studentExist);

		return "redirect:/students";

	}

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
		return "redirect:/students";
	}

}
