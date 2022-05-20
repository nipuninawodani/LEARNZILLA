package com.learnzilla.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
=======
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
>>>>>>> d7500c316520956e7b50f45fe3c5de27358df873

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class LearnzillaApplication {

	public static void main(String[] args) {

		SpringApplication.run(LearnzillaApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
