package com.estureview.backend;

import com.estureview.backend.entities.*;
import com.estureview.backend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserAppRepository userAppRepository,
								   ProfessorRepository professorRepository,
								   UniversityRepository universityRepository,
								   CourseRepository courseRepository,
								   ReviewRepository reviewRepository) {
		return args -> {
			// Crear y guardar algunas entidades de prueba

			// Universidades
			University university1 = new University();
			university1.setName("Universidad 1");
			universityRepository.save(university1);

			// Usuarios
			UserApp studentUser = new UserApp();
			studentUser.setName("Student User");
			studentUser.setEmail("student@example.com");
			studentUser.setPassword("password");
			studentUser.setUniversity(university1);
			studentUser.setRegistrationDate(new Date());
			studentUser.setRole("student");
			userAppRepository.save(studentUser);

			UserApp professorUser = new UserApp();
			professorUser.setName("Professor User");
			professorUser.setEmail("professor@example.com");
			professorUser.setPassword("password");
			professorUser.setUniversity(university1);
			professorUser.setRegistrationDate(new Date());
			professorUser.setRole("professor");
			userAppRepository.save(professorUser);

			// Profesores
			Professor professor1 = new Professor();
			professor1.setUserApp(professorUser);
			professor1.setFaculty("Faculty 1");
			professor1.setJoinDate(new Date());
			professorRepository.save(professor1);

			// Cursos
			Course course1 = new Course();
			course1.setCourseName("Course Name 1");
			course1.setCourseCode("Course Code 1");
			course1.setUniversity(university1);
			course1.setDescription("Description 1");
			courseRepository.save(course1);

			// Reseñas
			Review review1 = new Review();
			review1.setUserApp(studentUser);
			review1.setProfessor(professor1);
			review1.setCourse(course1);
			review1.setComment("Comment 1");
			review1.setRating(5);
			review1.setReviewDate(new Date());
			review1.setStatus("published");
			reviewRepository.save(review1);
		};
	}

}
