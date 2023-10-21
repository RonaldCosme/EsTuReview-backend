package com.estureview.backend;

import com.estureview.backend.entities.Role;
import com.estureview.backend.entities.University;
import com.estureview.backend.entities.UserApp;
import com.estureview.backend.repositories.UniversityRepository;
import com.estureview.backend.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;


@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private UserAppRepository userAppRepository;

	@Autowired
	private UniversityRepository universityRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Crear y guardar usuarios de ejemplo
		UserApp user1 = new UserApp();
		user1.setName("John Doe");
		user1.setEmail("john@example.com");
		user1.setUsername("john_doe");
		user1.setPassword(passwordEncoder.encode("jodo123")); // Asegúrate de encriptar la contraseña
		user1.setRegistrationDate(new Date());

		UserApp user2 = new UserApp();
		user2.setName("Jane Smith");
		user2.setEmail("jane@example.com");
		user2.setUsername("jane_smith");
		user2.setPassword(passwordEncoder.encode("jasm123"));
		user2.setRegistrationDate(new Date());


		UserApp user3 = new UserApp();
		user3.setName("Pedro Perez");
		user3.setEmail("pedro@example.com");
		user3.setUsername("pedro_perez");
		user3.setPassword(passwordEncoder.encode("pepe123"));
		user3.setRegistrationDate(new Date());

		UserApp user4 = new UserApp();
		user4.setName("Juan Garcia");
		user4.setEmail("juan@example.com");
		user4.setUsername("juan_garcia");
		user4.setPassword(passwordEncoder.encode("jgarcia123"));
		user4.setRegistrationDate(new Date());

		// Guardar en la base de datos
		userAppRepository.save(user1);
		userAppRepository.save(user2);
		userAppRepository.save(user3);
		userAppRepository.save(user4);


		// Crear y guardar universidades de ejemplo

		University university1 = new University();
		university1.setName("Universidad de Sevilla");
		university1.setCampus("Reina Mercedes");
		university1.setLocation("Sevilla");
		university1.setDescription("La Universidad de Sevilla es una universidad pública español");

		University university2 = new University();
		university2.setName("Universidad de Granada");
		university2.setCampus("Fuentenueva");
		university2.setLocation("Granada");
		university2.setDescription("La Universidad de Granada es una universidad pública española con sede en Granada.");


		University university3 = new University();
		university3.setName("Universidad de Málaga");
		university3.setCampus("Teatinos");
		university3.setLocation("Málaga");
		university3.setDescription("La Universidad de Málaga es una universidad pública española con sede en Málaga.");


		// Guardar en la base de datos
		universityRepository.save(university1);
		universityRepository.save(university2);
		universityRepository.save(university3);
	}

}
