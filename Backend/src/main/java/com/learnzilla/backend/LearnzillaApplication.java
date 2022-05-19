package com.learnzilla.backend;

import com.learnzilla.backend.email.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class LearnzillaApplication {

	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {

		SpringApplication.run(LearnzillaApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)

	public void sendMail(){
		senderService.sendEmail("learnzilla.lms@gmail.com",
				"this mail from learnzilla",
				"This is the mail body");

	}
}
