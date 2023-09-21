package com.estureview.backend;

import com.estureview.backend.entities.Course;
import com.estureview.backend.entities.University;
import com.estureview.backend.repositories.CourseRepository;
import com.estureview.backend.repositories.UniversityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


}
