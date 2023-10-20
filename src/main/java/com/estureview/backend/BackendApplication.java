package com.estureview.backend;

import com.estureview.backend.entities.UserApp;
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
		user1.setPassword(passwordEncoder.encode("password123")); // Asegúrate de encriptar la contraseña
		user1.setRegistrationDate(new Date());

		UserApp user2 = new UserApp();
		user2.setName("Jane Smith");
		user2.setEmail("jane@example.com");
		user2.setUsername("jane_smith");
		user2.setPassword(passwordEncoder.encode("password123"));
		user2.setRegistrationDate(new Date());

		// Guardar en la base de datos
		userAppRepository.save(user1);
		userAppRepository.save(user2);
	}


}
