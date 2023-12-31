package com.estureview.backend;

import com.estureview.backend.entities.*;
import com.estureview.backend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(
			CourseRepository courseRepository,
			ProfessorRepository professorRepository,
			ReviewCommentRepository reviewCommentRepository,
			ReviewRepository reviewRepository,
			UniversityRepository universityRepository,

			AuthorityRepository authorityRepository,
			UserRepository userRepository
	) {
		return args -> {
			//CRUD

			authorityRepository.save(new Authority(AuthorityName.ROLE_ADMIN));
			authorityRepository.save(new Authority(AuthorityName.ROLE_ALUMNO));
			authorityRepository.save(new Authority(AuthorityName.ROLE_PROFESSOR));

			authorityRepository.saveAll(
					List.of(
							new Authority(AuthorityName.READ),
							new Authority(AuthorityName.WRITE)
					)
			);


			userRepository.save(
					new User("admin", new BCryptPasswordEncoder().encode("admin!"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_ADMIN),
									authorityRepository.findByName(AuthorityName.WRITE)
							),"Geronima", "Ripeta",         Date.from(LocalDate.of(2002, 5, 9).atStartOfDay(ZoneId.systemDefault()).toInstant())
					)
			);

			userRepository.save(
					new User("crevilla", new BCryptPasswordEncoder().encode("DISEÑOPERU18!"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_ALUMNO),
									authorityRepository.findByName(AuthorityName.READ)
							), "Crecia", "Lopez",  Date.from(LocalDate.of(2003, 11, 10).atStartOfDay(ZoneId.systemDefault()).toInstant())
					)
			);

			//user profesor

			User userSaved = userRepository.save(
					new User("jose", new BCryptPasswordEncoder().encode("jose21"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_PROFESSOR),
									authorityRepository.findByName(AuthorityName.READ)
							), "Jose", "Lopez",  Date.from(LocalDate.of(2000, 11, 12).atStartOfDay(ZoneId.systemDefault()).toInstant())
					)
			);

			User userSaved2 = userRepository.save(
					new User("Feliciano", new BCryptPasswordEncoder().encode("feliciano13"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_PROFESSOR),
									authorityRepository.findByName(AuthorityName.READ)
							), "Feliciano", "Carbajal",  Date.from(LocalDate.of(1998, 11, 13).atStartOfDay(ZoneId.systemDefault()).toInstant())
					)
			);

			User userSaved3 = userRepository.save(
					new User("Luis", new BCryptPasswordEncoder().encode("luis12"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_PROFESSOR),
									authorityRepository.findByName(AuthorityName.READ)
							), "Luis", "Lopez",  Date.from(LocalDate.of(1999, 11, 14).atStartOfDay(ZoneId.systemDefault()).toInstant())
					)
			);

			User userSaved4 = userRepository.save(
					new User("Maria", new BCryptPasswordEncoder().encode("maria11"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_PROFESSOR),
									authorityRepository.findByName(AuthorityName.READ)
							), "Maria", "Lopez",  Date.from(LocalDate.of(1997, 11, 15).atStartOfDay(ZoneId.systemDefault()).toInstant())
					)
			);

			User userSaved5 = userRepository.save(
					new User("Juan", new BCryptPasswordEncoder().encode("juan10"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_PROFESSOR),
									authorityRepository.findByName(AuthorityName.READ)
							), "Juan", "Lopez",  Date.from(LocalDate.of(1996, 11, 16).atStartOfDay(ZoneId.systemDefault()).toInstant())
					)
			);


			University universitySaved = universityRepository.save(new University(Long.valueOf(0), "UPC", "SAN MIGUEL", "LA MARINA", "Una buena universidad", new HashSet<>()));
			universityRepository.save(new University(Long.valueOf(0), "UCV", "LIMA NORTE", "LOS OLIVOS", "No entender", new HashSet<>()));
			universityRepository.save(new University(Long.valueOf(0), "PUCP", "Lima", "San Miguel", "Una universidad reconocida", new HashSet<>()));
			universityRepository.save(new University(Long.valueOf(0), "UNMSM", "Lima", "Lima Cercado", "La universidad más antigua de América", new HashSet<>()));
			universityRepository.save(new University(Long.valueOf(0), "USMP", "Lima", "Santa Anita", "Educar para liderar", new HashSet<>()));
			universityRepository.save(new University(Long.valueOf(0), "UDEP", "Piura", "Piura", "Universidad de Piura", new HashSet<>()));
			universityRepository.save(new University(Long.valueOf(0), "UNI", "Lima", "Rímac", "Ciencia, Tecnología y Humanismo", new HashSet<>()));

			//*** COURSE *** /

			Course courseSaved1 = courseRepository.save(new Course(Long.valueOf(0), "Mate básica", "10021", "Lo más básico de mate", universitySaved, new HashSet<>()));
			Course courseSaved2 =courseRepository.save(new Course(Long.valueOf(0), "Mate avanzada", "10022", "Lo más avanzado de mate", universitySaved, new HashSet<>()));
			courseRepository.save(new Course(Long.valueOf(0), "Mate intermedia", "10023", "Lo más intermedio de mate", universitySaved, new HashSet<>()));
			courseRepository.save(new Course(Long.valueOf(0), "fisica", "10021", "este curso trata de fisica", universitySaved, new HashSet<>()));
			courseRepository.save(new Course(Long.valueOf(0), "quimica", "10028", "este curso trata de quimica", universitySaved, new HashSet<>()));
			courseRepository.save(new Course(Long.valueOf(0), "biologia", "10024", "este curso trata de biologia", universitySaved, new HashSet<>()));
			courseRepository.save(new Course(Long.valueOf(0), "historia", "10025", "este curso trata de historia", universitySaved, new HashSet<>()));
			courseRepository.save(new Course(Long.valueOf(0), "geografia", "10026", "este curso trata de geografia", universitySaved, new HashSet<>()));

			//*** PROFESSOR *** /

			Professor professorSaved1 = professorRepository.save(new Professor(Long.valueOf(0), userSaved, "Ingenieria", new Date(), new HashSet<>(),null,null));
			Professor professorSaved2 = professorRepository.save(new Professor(Long.valueOf(0), userSaved2, "Ciencias", new Date(), new HashSet<>(),null,null));
			professorRepository.save(new Professor(Long.valueOf(0), userSaved3, "Artes", new Date(), new HashSet<>(),null,null));
			professorRepository.save(new Professor(Long.valueOf(0), userSaved4, "Derecho", new Date(), new HashSet<>(),null,null));
			professorRepository.save(new Professor(Long.valueOf(0), userSaved5, "Medicina", new Date(), new HashSet<>(),null,null));
			professorRepository.save(new Professor(Long.valueOf(0), userSaved5, "Matematicas", new Date(), new HashSet<>(),null,null));








			//universityRepository.delete(universitySaved);

			//Un solo objeto como resultado
			University universityFound = universityRepository.findById(Long.valueOf(3)).get();

			//Una lista de objetos como resultado

			/*List<Employee> employeeAll = employeeRepository.findAll();
			System.out.println("\nLista Completa");
			for(Employee e: employeeAll) {
				System.out.println(e);
			}

			System.out.println("\nLista por Ciudad");
			List<Employee> employeeCiudad= employeeRepository.findByCityOrderByNameDesc("Lima");
			for(Employee e: employeeCiudad) {
				System.out.println(e);
			}

			System.out.println("\nLista por Ciudad y Nombre");
			List<Employee> employeeCiudadNombre = employeeRepository.findByCityAndName("Lima","Gonzalo");
			for(Employee e: employeeCiudadNombre) {
				System.out.println(e);
			}


			System.out.println("\nLista por similitud Nombre");
			List<Employee> employeeNombreParecido = employeeRepository.findByNameContaining("G");
			for(Employee e: employeeNombreParecido) {
				System.out.println(e);
			}

			System.out.println("\nLista por Ciudad y Menor Salario");
			//List<Employee> employeeCiudadMenorSalario = employeeRepository.findByCityAndLowerSalary("Lima", 10000.0);
			//List<Employee> employeeCiudadMenorSalario = employeeRepository.findByCityAndSalaryLessThan("Lima", 10000.0);
			List<Employee> employeeCiudadMenorSalario = employeeRepository.findByCityAndLowerSalaryJPQL("Lima", 10000.0);
			for(Employee e: employeeCiudadMenorSalario) {
				System.out.println(e);
			}

			System.out.println("\nLista por Rango Salario");
			List<Employee> employeeRangoSalario = employeeRepository.findBySalaryBetween(1000.0, 10000.0);
			for(Employee e: employeeRangoSalario) {
				System.out.println(e);
			}*/

			//UPDATE ERROR COMUN
			//Ejemplo: Cuando te pasan un ID y el nuevo salario
			//Version que elimina datos equivocadamente
			/*
			Long idEmployeePromoted = Long.valueOf(8);
			Double newSalaryEmployeePromoted = 5000.0;

			Employee e = new Employee();
			e.setSalary(newSalaryEmployeePromoted);
			e.setId(idEmployeePromoted);
			Employee employeePromoted =  employeeRepository.save(e);
			System.out.println("\n"+employeePromoted);
			*/

			//VERSION CORRECTA

			/*Long idEmployeePromoted = Long.valueOf(8);
			Double newSalaryEmployeePromoted = 5000.0;
			Employee e = employeeRepository.findById(idEmployeePromoted).get();
			e.setSalary(newSalaryEmployeePromoted);
			e.setId(idEmployeePromoted);
			Employee employeePromoted =  employeeRepository.save(e);
			System.out.println("\n"+employeePromoted);*/




			//*** PROFESSOR *** /



			//*** REVIEW *** //


			Review review1 = new Review();
			review1.setProfessor(professorSaved1);
			review1.setCourse(courseSaved1);
			review1.setComment("El profesor me enseña de manera clara y concisa");
			review1.setRating(8);
			review1.setReviewDate(new Date());
			review1.setStatus("published");
			reviewRepository.save(review1);

			Review review2 = new Review();
			review2.setProfessor(professorSaved2);
			review2.setCourse(courseSaved2);
			review2.setComment("El profeosr es muy amable");
			review2.setRating(7);
			review2.setReviewDate(new Date());
			review2.setStatus("published");
			reviewRepository.save(review2);

			Review review3 = new Review();
			review3.setProfessor(professorSaved1);
			review3.setCourse(courseSaved1);
			review3.setComment("El profesor me enseña de manera clara y concisa");
			review3.setRating(8);
			review3.setReviewDate(new Date());
			review3.setStatus("published");
			reviewRepository.save(review3);

			Review review4 = new Review();
			review4.setProfessor(professorSaved2);
			review4.setCourse(courseSaved2);
			review4.setComment("El profeosr es muy amable");
			review4.setRating(7);
			review4.setReviewDate(new Date());
			review4.setStatus("published");
			reviewRepository.save(review4);







			//Review coment
			ReviewComment reviewComment1 = new ReviewComment();
			reviewComment1.setText("Gracias por tu comentario");
			reviewComment1.setTag("Atento");
			reviewComment1.setCommentDate(new Date());
			reviewComment1.setReview(review1);
			reviewCommentRepository.save(reviewComment1);

			ReviewComment reviewComment2 = new ReviewComment();
			reviewComment2.setText("Saludos desde el campus universitario");
			reviewComment2.setTag("Amigable");
			reviewComment2.setCommentDate(new Date());
			reviewComment2.setReview(review2);
			reviewCommentRepository.save(reviewComment2);

			ReviewComment reviewComment3 = new ReviewComment();
			reviewComment3.setText("Quedo atención a tus comentarios");
			reviewComment3.setTag("Disponible");
			reviewComment3.setCommentDate(new Date());
			reviewComment3.setReview(review3);
			reviewCommentRepository.save(reviewComment3);

			ReviewComment reviewComment4 = new ReviewComment();
			reviewComment4.setText("Estoy de acuerdo contigo");
			reviewComment4.setTag("Amigable");
			reviewComment4.setCommentDate(new Date());
			reviewComment4.setReview(review4);
			reviewCommentRepository.save(reviewComment4);






			/*projectRepository.save(new Project(Long.valueOf(0),"Frontend RRHH", 17500.0,null));
			projectRepository.save(new Project(Long.valueOf(0),"Backend RRHH", 25000.0,null));
			projectRepository.save(new Project(Long.valueOf(0),"Security Check 2023", 7000.0,null));

			Project project1 = projectRepository.findById(Long.valueOf(1)).get();
			Project project2 = projectRepository.findById(Long.valueOf(2)).get();

			Employee employee1 = employeeRepository.findById(Long.valueOf(2)).get();
			Employee employee2 = employeeRepository.findById(Long.valueOf(4)).get();
			Employee employee3 = employeeRepository.findById(Long.valueOf(6)).get();
			Employee employee4 = employeeRepository.findById(Long.valueOf(7)).get();
			Employee employee5 = employeeRepository.findById(Long.valueOf(8)).get();


			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project1, employee1, 14, false));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project1, employee3, 10, true));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project1, employee5, 9, false));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project2, employee1, 28, true));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project2, employee2, 15, false));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project2, employee3, 4, true));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project2, employee4, 18, true));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project2, employee5, 9, false))*/




			/*List<EmployeeProject> employeeProjectList = employeeProjectService.listAll();
			for (EmployeeProject ep: employeeProjectList) {
				System.out.println(ep);
			}*/







		};
	}

}




