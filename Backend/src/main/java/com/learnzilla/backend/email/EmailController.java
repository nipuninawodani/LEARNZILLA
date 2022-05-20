package com.learnzilla.backend.email;

import com.learnzilla.backend.announcements.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class EmailController {

    @Autowired
    private EmailSenderService senderService;

    public static void main(String[] args) {
        SpringApplication.run(EmailController.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)

    public void sendMail(){
        Announcement announcement = new Announcement();

        senderService.sendEmail("learnzilla.lms@gmail.com",
                "this mail from learnzilla",
                "This is the mail body");

    }
}
