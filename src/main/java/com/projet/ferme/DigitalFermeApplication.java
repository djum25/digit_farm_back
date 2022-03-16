package com.projet.ferme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.projet.ferme.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class DigitalFermeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalFermeApplication.class, args);
	}

}
