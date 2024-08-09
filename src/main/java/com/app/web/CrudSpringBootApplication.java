package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entity.Student;
import com.app.web.repository.StudentRepository;

@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootApplication.class, args);
	}

	
	@Autowired
	private StudentRepository repository;
	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student("Fred", "Rios","frios@gmail.com");
//		 repository.save(student1);
//		 Student student2 = new Student("Nadiia", "Rios","nrios@gmail.com");
//		 repository.save(student2);
//		
		
	}

}
