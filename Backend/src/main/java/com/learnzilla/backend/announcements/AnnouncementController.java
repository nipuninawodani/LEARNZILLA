package com.learnzilla.backend.announcements;

import com.learnzilla.backend.email.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class AnnouncementController {

    private AnnouncementRepository announcementRepository;
    @Autowired
    private EmailSenderService mailSender;

    @Autowired
    public AnnouncementController(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @GetMapping("/learnzilla/announcement/{id}")
    public Announcement getAnnouncement(@PathVariable Integer id){

        return announcementRepository.findById(id).get();
    }

    @GetMapping("/learnzilla/announcement")
    public List<Announcement> getAnnouncements(){
        return announcementRepository.findAll();
    }

    @PostMapping("/learnzilla/announcement")
    public void setAnnouncement(@RequestBody Announcement announcement){
      announcementRepository.save(announcement);
       mailSender.sendEmail("learnzilla.lms@gmail.com",announcement.title,announcement.message);
    }

}


