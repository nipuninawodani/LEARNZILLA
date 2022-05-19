package com.learnzilla.backend.announcements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AnnouncementController {


    private AnnouncementRepository announcementRepository;

    @Autowired
    public AnnouncementController(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @GetMapping("/announcement/{id}")
    public Announcement getAnnouncement(@PathVariable Integer id){
        return announcementRepository.findById(id).get();
    }

    @PostMapping("/announcement")
    public void setAnnouncement(@RequestBody Announcement announcement){
      announcementRepository.save(announcement);

      System.out.println("This is the number "+ announcement.id+ " from your course " + announcement.course_code);
      System.out.println("This announcement is send on " + announcement.date);
      System.out.println(announcement.message);

    }

}