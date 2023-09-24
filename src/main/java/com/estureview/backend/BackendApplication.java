package com.estureview.backend;

import com.estureview.backend.entities.Course;
import com.estureview.backend.repositories.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
	public CommandLineRunner mappingDemo(CourseRepository courseRepository) {
	return args -> {
	 	courseRepository.save(new Course(Long.valueOf(0),"CU29", "MATEMATICA","u201824342"));
	};
	};
}
