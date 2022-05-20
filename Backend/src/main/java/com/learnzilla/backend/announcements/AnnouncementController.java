package com.learnzilla.backend.announcements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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

    @GetMapping("/announcement")
    public List<Announcement> getAnnouncements(){
        return announcementRepository.findAll();
    }

    @PostMapping("/announcement")
    public void setAnnouncement(@RequestBody Announcement announcement){
      announcementRepository.save(announcement);


        System.out.println(announcement.message);
    }

}