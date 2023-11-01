package com.estureview.backend;

import com.estureview.backend.entities.*;
import com.estureview.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class BackendApplication  implements CommandLineRunner{

	@Autowired
	private UserAppRepository userAppRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private UniversityRepository universityRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ReviewCommentRepository reviewCommentRepository;

	@Autowired
	private ModerationActionRepository moderationActionRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;



	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		// Crear y guardar algunas entidades de prueba

		// Universidades
		University university1 = new University();
		university1.setName("University 1");
		university1.setCampus("Campus 1");
		university1.setLocation("Lugar 1");
		university1.setDescription("Description uni 1");
		universityRepository.save(university1);

		University university2 = new University();
		university2.setName("University 2");
		university2.setCampus("Campus 2");
		university2.setLocation("Lugar 2");
		university2.setDescription("Description uni 2");
		universityRepository.save(university2);

		// Usuarios
		UserApp studentUser = new UserApp();
		studentUser.setName("Student User");
		studentUser.setEmail("student@example.com");
		studentUser.setUsername("studentUser");  // Agregado
		studentUser.setPassword(passwordEncoder.encode("password"));
		studentUser.setUniversity(university1);
		studentUser.setRegistrationDate(new Date());
		studentUser.setRole(Role.ALUMNO);
		userAppRepository.save(studentUser);

		UserApp professorUser = new UserApp();
		professorUser.setName("Professor User");
		professorUser.setEmail("professor@example.com");
		professorUser.setUsername("professorUser");
		professorUser.setPassword(passwordEncoder.encode("password"));
		professorUser.setUniversity(university2);
		professorUser.setRegistrationDate(new Date());
		professorUser.setRole(Role.PROFESOR);
		userAppRepository.save(professorUser);

		UserApp adminUser = new UserApp();
		adminUser.setName("Admin User");
		adminUser.setEmail("admin@example.com");
		adminUser.setUsername("adminUser");
		adminUser.setPassword(passwordEncoder.encode("password"));
		adminUser.setUniversity(null);
		adminUser.setRegistrationDate(new Date());
		adminUser.setRole(Role.ADMIN);
		userAppRepository.save(adminUser);


		// Profesores
		Professor professor1 = new Professor();
		professor1.setUserApp(professorUser);
		professor1.setFaculty("Faculty 1");
		professor1.setJoinDate(new Date());
		professorRepository.save(professor1);

		Professor professor2 = new Professor();
		professor2.setUserApp(professorUser);
		professor2.setFaculty("Faculty 2");
		professor2.setJoinDate(new Date());
		professorRepository.save(professor2);


		// Cursos
		Course course1 = new Course();
		course1.setCourseName("Course Name 1");
		course1.setCourseCode("Course Code 1");
		course1.setUniversity(university1);
		course1.setDescription("Description 1");
		courseRepository.save(course1);

		Course course2 = new Course();
		course2.setCourseName("Course Name 2");
		course2.setCourseCode("Course Code 2");
		course2.setUniversity(university2);
		course2.setDescription("Description 2");
		courseRepository.save(course2);

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

		Review review2 = new Review();
		review2.setUserApp(professorUser);
		review2.setProfessor(professor2);
		review2.setCourse(course1);
		review2.setComment("Comment 2");
		review2.setRating(0);
		review2.setReviewDate(new Date());
		review2.setStatus("published");
		reviewRepository.save(review2);

		//Review coment
		ReviewComment reviewComment1 = new ReviewComment();
		reviewComment1.setText("review coment 1");
		reviewComment1.setTag("tag1");
		reviewComment1.setCommentDate(new Date());
		reviewComment1.setReview(review1);
		reviewComment1.setUserApp(professorUser);
		reviewCommentRepository.save(reviewComment1);

		ReviewComment reviewComment2 = new ReviewComment();
		reviewComment2.setText("review coment 2");
		reviewComment2.setTag("tag2");
		reviewComment2.setCommentDate(new Date());
		reviewComment2.setReview(review2);
		reviewComment2.setUserApp(professorUser);
		reviewCommentRepository.save(reviewComment2);

		//action

		ModerationAction action1 = new ModerationAction();
		action1.setActionType("Eliminar");
		action1.setActionDate(new Date());
		action1.setComment("comentario 1");
		action1.setReview(review1);
		action1.setAdmin(adminUser);
		moderationActionRepository.save(action1);

		ModerationAction action2 = new ModerationAction();
		action2.setActionType("Editar");
		action2.setActionDate(new Date());
		action2.setComment("comentario 2");
		action2.setReview(review2);
		action2.setAdmin(adminUser);
		moderationActionRepository.save(action2);

	}
}

